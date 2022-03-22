<?php

declare(strict_types=1);

namespace Tests;

use ApprovalTests\Approvals;
use Error;
use PHPUnit\Framework\TestCase;
use Theatrical\base.Invoice;
use Theatrical\base.Performance;
use Theatrical\base.Play;
use Theatrical\base.StatementPrinter;

final class StatementPrinterTest extends TestCase
{
    public function testCanPrintInvoice(): void
    {
        $plays = [
            'hamlet' => new base.Play('Hamlet', 'tragedy'),
            'as-like' => new base.Play('As You Like It', 'comedy'),
            'othello' => new base.Play('Othello', 'tragedy'),
        ];

        $performances = [
            new base.Performance('hamlet', 55),
            new base.Performance('as-like', 35),
            new base.Performance('othello', 40),
        ];
        $invoice = new base.Invoice('BigCo', $performances);
        $statementPrinter = new base.StatementPrinter();
        $result = $statementPrinter->print($invoice, $plays);

        Approvals::verifyString($result);
    }

    public function testNewPlayTypes(): void
    {
        $plays = [
            'henry-v' => new base.Play('Henry V', 'history'),
            'as-like' => new base.Play('As You Like It', 'comedy'),
        ];

        $performances = [new base.Performance('henry-v', 53), new base.Performance('as-like', 55)];

        $invoice = new base.Invoice('BigCo', $performances);
        $statementPrinter = new base.StatementPrinter();
        $this->expectException(Error::class);
        $statementPrinter->print($invoice, $plays);
    }
}
