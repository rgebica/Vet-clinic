package com.clinic.vetclinic.termTests

import groovyx.net.http.RESTClient
import spock.lang.Specification

import static groovyx.net.http.ContentType.*

class TermSpec extends Specification {
    def client = new RESTClient("http://localhost:8080");

    def "should add new term"() {
        when: "try to add new term"
        def response = client.post(path: "/api/create-term",
                body: [
                        date    : date,
                        doctorId: doctorId,
                        hour    : hour,
                ],
                requestContentType: JSON);
        then: "should return 201 status and create term"
        with(response) {
            status == 201
        }
        where:
        date         | doctorId | hour
        "2020-12-13" | 1        | "19:00"
    }

    def "should get all terms by doctor"() {
        when: "try to get all terms"
        def response = client.get(path: "/api/all-terms/1");
        then: "should get all terms by user"
        with(response) {
            response.findAll()
        }
    }

    def "should get open terms by doctor and date"() {
        when: "try to get all terms"
        def response = client.get(path: "/api/terms-date/1/2020-12-13");
        then: "should get all terms by user and date"
        with(response) {
            response.findAll()
        }
    }

//    def "should cancel visit by customer"() {
//        when: "try to cancel visit"
//        def response = client.delete(path: "/api/cancel-term",
//        body:
//        [
//                codePin: codePin,
//                userId : userId,
//                visitId: visitId,
//        ],
//        requestContentType: JSON);
//        then: "should get all terms by user and date"
//        with(response) {
//            status == 200
//        }
//        where:
//        codePin | userId | visitId
//        1234    | 1000   | 1
//    }
}