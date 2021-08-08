package pl.zuchol.wimf;

import spock.lang.Specification

class BasicIntegrationSpec extends Specification {

    def "one plus one should equal two"() {
        expect:
        1 + 1 == 2
    }

}