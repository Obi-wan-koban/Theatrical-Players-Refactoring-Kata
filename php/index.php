<?php

declare(strict_types=1);

use Theatrical\HtmlStatement;
use Theatrical\base.Invoice;
use Theatrical\base.Performance;
use Theatrical\base.Play;

require __DIR__ . '/vendor/autoload.php';

$plays = [
    "hamlet" => new base.Play("Hamlet", "tragedy"),
    "as-like" => new base.Play("As You Like It", "comedy"),
    "othello" => new base.Play("Othello", "tragedy")
];

$performances = [
    new base.Performance("hamlet", 55),
    new base.Performance("as-like", 35),
    new base.Performance("othello", 40)
];
$invoice = new base.Invoice("BigCo", $performances);

echo "<h1>Html Statement</h1>";

// Uncomment the following two line once the HtmlStatement Class is written (Ch.1 page 31)
//$statementPrinter = new HtmlStatement();
//echo  $statementPrinter->print($invoice, $plays);
