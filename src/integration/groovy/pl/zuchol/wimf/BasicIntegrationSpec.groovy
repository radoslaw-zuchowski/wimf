package pl.zuchol.wimf

import groovyx.net.http.RESTClient
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.ContextConfiguration
import pl.zuchol.wimf.food.FoodRepository
import spock.lang.Shared
import spock.lang.Specification

@SpringBootTest(
        classes = WimfApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT
)
@ActiveProfiles("integration")
@ContextConfiguration
class BasicIntegrationSpec extends Specification {

    @Shared
    static String testURL = "http://localhost:8092"

    def client = new RESTClient(testURL, "application/json")

    @Autowired
    protected FoodRepository foodRepository
}