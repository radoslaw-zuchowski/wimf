package pl.zuchol.wimf.food

import groovyx.net.http.HttpResponseException
import pl.zuchol.wimf.BasicIntegrationSpec

class FoodIntegrationSpec extends BasicIntegrationSpec {

    private static final String FOOD_NAME = 'food_name'
    private static final String SECOND_FOOD_NAME = 'second_food_name'
    private static final String FOODS_PATH = '/foods/'

    def setup() {
        foodRepository.deleteAll();
    }

    def "should save food to database on create request"() {
        given: 'Correct request body'
            def requestBody = [name: FOOD_NAME, quantity: [value: 5, unit: 'GRAMS']]

        when: 'Send request for creating food'
            def response = client.post(
                    path : FOODS_PATH,
                    body : requestBody,
                    requestContentType : 'application/json'
            )

        then: 'Server returns 201 code (created)'
            assert response.status == 201

        and: 'There is 1 more document in collection'
            assert foodRepository.count() == 1
    }

    def "should get all "() {
        given: 'Saved 2 foods'
            createFood(FOOD_NAME)
            createFood(SECOND_FOOD_NAME)

        when: "Send request for all"
            def response = client.get(
                    path : FOODS_PATH,
                    requestContentType : 'application/json'
            )

        then: 'Server returns 200 code (OK)'
            assert response.status == 200

        and: 'There is 2 alements in response list'
            assert response.getAt("data").size() == 2
    }

    def "should get by name "() {
        given: 'Saved foods'
            createFood(FOOD_NAME)

        when: "Send request for one by name "
            def response = client.get(
                    path : FOODS_PATH + FOOD_NAME,
                    requestContentType : 'application/json'
            )

        then: 'Server returns 200 code (OK)'
            assert response.status == 200

        and: 'Element in response have name like name from request'
            assert response.getAt("data").name == FOOD_NAME
    }

    def "should return 404 when food not found "() {
        given: 'When no food is saved'

        when: "Send request by name"
            client.get(
                    path : FOODS_PATH + FOOD_NAME,
                    requestContentType : 'application/json'
            )

        then: 'Server returns 404 code (NOT_FOUND)'
            HttpResponseException ex = thrown()
            assert ex.statusCode == 404
            assert ex.response.data.getAt("code") == "FoodNotFoundException"
            assert ex.response.data.getAt("message") ==  "Food with name food_name not found"
    }

    def "should delete by name "() {
        given: 'Saved foods'
            createFood(FOOD_NAME)

        when: "Send request for delete name "
            def response = client.delete(
                    path : FOODS_PATH + FOOD_NAME
            )

        then: 'Server returns 200 code (OK)'
            assert response.status == 200

        and: 'And there is no food in database'
            assert foodRepository.count() == 0
    }

    private Object createFood(name) {
        def requestBody = [
                name: name,
                quantity: [
                        value: 5,
                        unit: 'GRAMS'
                ]
        ]
        return client.post(
                path : FOODS_PATH,
                body : requestBody,
                requestContentType : 'application/json'
        )
    }

}
