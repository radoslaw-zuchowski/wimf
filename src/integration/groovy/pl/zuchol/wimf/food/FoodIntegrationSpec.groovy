package pl.zuchol.wimf.food

import pl.zuchol.wimf.BasicIntegrationSpec

class FoodIntegrationSpec extends BasicIntegrationSpec {

    def "should save food to database on create request"() {
        given: 'Correct request body'
        def requestBody = [name: 'first_test', quantity: [value: 5, unit: 'GRAMS']]
        def documentsNumber = foodRepository.count()

        when: 'Send request for creating food'
        def response = client.post(
                path : '/foods',
                body : requestBody,
                requestContentType : 'application/json'
        )

        then: 'Server returns 201 code (created)'
        assert response.status == 200
        and: 'There is 1 more document in collection'
        assert foodRepository.count() == documentsNumber + 1
    }

}
