package theatre_test

import (
	"encoding/json"
	"testing"

	"github.com/emilybache/Theatrical-Players-Refactoring-Kata/go/theatre"
)

func TestPrinterPrintByApproval(t *testing.T) {
	verify(t, "json", "txt", func(t testing.TB, data []byte) []byte {
		var in struct {
			Plays []struct {
				ID   string
				base.Play struct {
					Name string
					Type string
				}
			}
			base.Invoice struct {
				Customer     string
				Performances []struct {
					PlayID   string
					Audience int
				}
			}
		}

		if err := json.Unmarshal(data, &in); err != nil {
			t.Fatalf("failed to unmarshal input data: %v", err)
			return nil
		}

		// copy test-structure to production structure. Making use of matching types.
		plays := make(map[string]theatre.base.Play)
		invoice := theatre.base.Invoice{
			Customer:     in.base.Invoice.Customer,
			Performances: make([]theatre.base.Performance, 0, len(in.base.Invoice.Performances)),
		}
		for _, perf := range in.base.Invoice.Performances {
			invoice.Performances = append(invoice.Performances, perf)
		}
		for _, identifiedPlay := range in.Plays {
			plays[identifiedPlay.ID] = identifiedPlay.base.Play
		}

		var printer theatre.base.StatementPrinter
		statement, err := printer.Print(invoice, plays)
		if err != nil {
			t.Fatalf("failed to create statement, unexpected error: %v", err)
		}
		return []byte(statement)
	})
}

func TestStatementWithNewPlayTypes(t *testing.T) {
	plays := map[string]theatre.base.Play{
		"henry-v": {Name: "Henry V", Type: "history"},
		"as-like": {Name: "As You Like It", Type: "pastoral"},
	}
	invoice := theatre.base.Invoice{
		Customer: "BigCo",
		Performances: []theatre.base.Performance{
			{PlayID: "henry-v", Audience: 53},
			{PlayID: "as-like", Audience: 55},
		},
	}

	var printer theatre.base.StatementPrinter
	_, err := printer.Print(invoice, plays)
	if err == nil {
		t.Errorf("Expected an error, got none")
	}
}
