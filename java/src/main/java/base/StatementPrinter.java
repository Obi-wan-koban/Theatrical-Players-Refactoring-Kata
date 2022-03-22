package base;

import base.calculation.PerformancePlayCalculator;
import base.factory.PerformancePlayFactory;
import base.writer.InvoiceAggregateJsonWriter;

import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import static base.writer.InvoiceLineDefaultWriter.frmt;

public class StatementPrinter {
    PerformancePlayFactory factory = new PerformancePlayFactory();

    public String print(Invoice invoice, Map<String, Play> plays) {
        InvoiceAggregate invoiceAggregate = createInvoiceAggregate(invoice, plays);
        return invoiceAggregate.toString();
    }

    public String printJson(Invoice invoice, Map<String, Play> plays) {
        InvoiceAggregate invoiceAggregate = createInvoiceAggregate(invoice, plays);
        invoiceAggregate.setWriter(new InvoiceAggregateJsonWriter(invoiceAggregate));
        return invoiceAggregate.toString();
    }

    private InvoiceAggregate createInvoiceAggregate(Invoice invoice, Map<String, Play> plays) {
        AtomicInteger totalAmount = new AtomicInteger(0);
        AtomicInteger volumeCredits = new AtomicInteger(0);

        List<InvoiceLine> invoiceLines = invoice.performances.stream().map(performance -> {
            var play = plays.get(performance.playID);
            PerformancePlayCalculator performancePlayCalculator = factory.createPerformancePlayCalculator(play, performance);
            InvoiceLine invoiceLine = new InvoiceLine(performancePlayCalculator);
            totalAmount.addAndGet(performancePlayCalculator.calculateAmount());
            volumeCredits.addAndGet(invoiceLine.getVolume());
            return invoiceLine;
        }).collect(Collectors.toList());
        String formattedTotalAmount = frmt.format(totalAmount.get() / 100);
        return new InvoiceAggregate(formattedTotalAmount, volumeCredits.get(), invoice.customer, invoiceLines);
    }


}
