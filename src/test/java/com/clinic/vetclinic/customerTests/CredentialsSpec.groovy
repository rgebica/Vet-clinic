package com.clinic.vetclinic.customerTests

import com.clinic.vetclinic.service.VisitService
import spock.lang.Specification
import spock.lang.Unroll

class CredentialsSpec extends Specification {

    VisitService visitService;

    @Unroll
    def "should return NullPointerException"(codePin, customerId) {
        when: "customer wants to take a term"
        visitService.takeTerm()
        then:
        thrown(NullPointerException)
        where:
        codePin | customerId
        ""      | null
    }
}
