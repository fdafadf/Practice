﻿$WebResponse = Invoke-WebRequest "https://stooq.pl/q/?s=usdpln"

$stockValue = $WebResponse.AllElements | where id -EQ "aq_usdpln_c5" | select innertext
$stockTime = $WebResponse.AllElements | where id -EQ "aq_usdpln_d2" | select innertext 
$stockDate = $WebResponse.AllElements | where id -EQ "aq_usdpln_t1" | select innertext 

Write-Host -ForegroundColor Yellow 'USDPLN'
Write-Host -ForegroundColor Green $stockValue.innerText
Write-Host -ForegroundColor Green $stockTime.innerText
Write-Host -ForegroundColor Green $stockDate.innerText

# $WebResponse.AllElements | where tagname -EQ "span" | select innerText
# tutorial:
# https://www.youtube.com/watch?v=QrC3ErlxpII