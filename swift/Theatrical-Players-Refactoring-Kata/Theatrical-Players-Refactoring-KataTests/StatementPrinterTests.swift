
import XCTest
@testable import Theatrical_Players_Refactoring_Kata

class StatementPrinterTests: XCTestCase {
    func test_exampleStatement() throws {
        
        let expected = """
            Statement for BigCo
              Hamlet: $650.00 (55 seats)
              As You Like It: $580.00 (35 seats)
              Othello: $500.00 (40 seats)
            Amount owed is $1,730.00
            You earned 47 credits

            """
        
        let plays = [
            "hamlet": base.Play(name: "Hamlet", type: "tragedy"),
            "as-like": base.Play(name: "As You Like It", type: "comedy"),
            "othello": base.Play(name: "Othello", type: "tragedy")
        ]
        
        let invoice = base.Invoice(
            customer: "BigCo", performances: [
                base.Performance(playID: "hamlet", audience: 55),
                base.Performance(playID: "as-like", audience: 35),
                base.Performance(playID: "othello", audience: 40)
            ]
        )
        
        let statementPrinter = base.StatementPrinter()
        let result = try statementPrinter.print(invoice, plays)
        
        XCTAssertEqual(result, expected)
    }
    
    func test_statementWithNewPlayTypes() {
        let plays = [
            "henry-v": base.Play(name: "Henry V", type: "history"),
            "as-like": base.Play(name: "As You Like It", type: "pastoral")
        ]
        
        let invoice = base.Invoice(
            customer: "BigCo", performances: [
                base.Performance(playID: "henry-v", audience: 53),
                base.Performance(playID: "as-like", audience: 55)
            ]
        )
        
        let statementPrinter = base.StatementPrinter()
        XCTAssertThrowsError(try statementPrinter.print(invoice, plays))        
    }
}

