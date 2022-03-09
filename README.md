<h2>Smart home</h2>

<h2>Cleni tymu:</h2> Stanislav Chaban (chabasta) 

<h2>Kratky popis</h2>

Vytvořitl jsem aplikaci pro virtuální simulaci inteligentního domu, kde se simuluje chod domácnosti, používá se jednotlivá zařízení domu a spocita se spotřebu plynu, vody a eletriny ruznych zařízení .

<h2>Funkční požadavky</h2>
Funkční požadavek je zobrazen jako <strong>bold</strong>, splněný požadavek jako podbod v čistém textu a nesplněný/nedokončený požadavek je podbod v <em>italics</em><br>.

<ol>
<li><strong>Entity se kterými pracujeme je dům, okno (+ venkovní žaluzie), patro v domu, senzor, zařízení (=spotřebič), osoba, auto, kolo, domácí zvíře jiného než hospodářského typu, plus libovolné další entity</strong>

1. Splněno v packages Devices, Resident a house
2. <em>Bohuzel nepouzil jsem senzory a žaluzie</em>

<li><strong>Jednotlivá zařízení v domu mají API na ovládání. Zařízení mají stav, který lze měnit pomocí API na jeho ovládání. Akce z API jsou použitelné podle stavu zařízení. Vybraná zařízení mohou mít i obsah - lednice má jídlo, CD přehrávač má CD.</strong>

1. Každé zařízení má vlastní stav, který se může změnit náhodně (zařízení má malou šanci na rozbití při puziti)
2. Lidé mohou se zařízením interagovat a dospělí mohou rozbitá zařízení opravovat
3. <em>Bohužel zařízení nemají měnitelný obsah.</em>

<li><strong>Spotřebiče mají svojí spotřebu v aktivním stavu, idle stavu, vypnutém stavu</strong>

1. Zařízení spotřebovávají elektřinu, plyn a vodu podle svého stavu (aktivní spotřebuje víc než nečinné)

<li><strong>Jednotlivá zařízení mají API na sběr dat o tomto zařízení. O zařízeních sbíráme data jako spotřeba elektřiny, plynu, vody a funkčnost (klesá lineárně s časem)</strong>

1. Spotřeba se zaznamenává po ukonceni zadaneho casu.
2. Pak se generujou reporty spotreby pro kazde zarizeni a i celkem kolik bylo spotrebovano plynu, vody a eletriny.

<li><strong>Jednotlivé osoby a zvířata mohou provádět aktivity(akce), které mají nějaký efekt na zařízení nebo jinou osobu. Např. Plynovy_kotel_1[oteverny_plyn] + Otec.zavritPlyn(plynovy_kotel_1) -> Plynovy_kotel_1[zavreny_plyn].</strong>

1. Osoby mohou se zařízením interagovat a po použití mají zařízení šanci, že se rozbijí.
2. <em>Hlubší interakce se zařízeními bohužel není</em>

<li><strong>Jednotlivá zařízení a osoby se v každém okamžiku vyskytují v jedné místnosti (pokud nesportují) a náhodně generují eventy (eventem může být důležitá informace a nebo alert)</strong>

1. Osoby i zvířata nachází se právě v jedné místnosti najednou a muzou generovat eventy (rozbiti zarizeni anebo zvirata mohou chtit se nechat pohladit nebo poprosit jist).

<li><strong>Eventy jsou přebírány a odbavovány vhodnou osobou (osobami) nebo zařízením (zařízeními)</strong>

1. Opravovat rozbite zařízení muzou jen dospělé osoby

<li><strong>Vygenerování reportů: HouseConfigurationReport, EventReport, ActivityAndUsageReport, ConsumptionReport</strong>

1. Generuje se report o aktuální konfiguraci domu
2. Generuje se report o aktuálních aktivitách v domě
3. Generuje se report o aktuální spotřebě v domě
4. Generuje se report o eventach v domě
5. Všechny reporty se generují do společného souboru (ReportsFiles - {Nazev reportu}.txt)

<li><strong>Při rozbití zařízení musí obyvatel domu prozkoumat dokumentaci k zařízení - najít záruční list, projít manuál na opravu a provést nápravnou akcí (např. Oprava svépomocí, koupě nového atd.). Manuály zabírají mnoho místa a trvá dlouho než je najdete.</strong>

1. <em>Neni splneno</em>

<li><strong>Rodina je aktivní a volný čas tráví zhruba v poměru (50% používání spotřebičů v domě a 50% sport kdy používá sportovní náčiní kolo nebo lyže). Když není volné zařízení nebo sportovní náčiní, tak osoba čeká.</strong>


1. <em>Bohuzel lidi nahodne pouzivaji zarizeni </em>
</ol>
<h2>Nefunkční požadavky</h2>
<ul>
<li>Není požadována autentizace ani autorizace ✅

<li>Aplikace může běžet pouze v jedné JVM ✅

<li>Reporty jsou generovány do textového souboru ✅

<li>Aplikaci pište tak, aby byly dobře schované metody a proměnné, které nemají být dostupné ostatním třídám. Vygenerovný javadoc by měl mít co nejméně public metod a proměnných. ✅ </li>
</ul>
<h2>Design patterny</h2>

State machine ✅
<ul>
<li>device/Device.java
<li>device/state
</ul>

Iterator ✅
<ul>
<li>house/RoomIterator
</ul>

Factory/Factory method ✅<br>
Singleton ✅
<ul>
<li>devices/DeviceFactory.java
<li>house/HouseFactory
</ul>

Builder✅
<ul>
<li>house/House.java (HouseBuilder)
</ul>
<h2>Požadované výstupy</h2>

Design ve formě use case diagramů, class diagramů a stručného popisu jak chcete úlohu realizovat ✅
<ul>
<li>Dostupné v /diagrams</li>
</ul>

Veřejné API - Javadoc vygenerovaný pro funkce, kterými uživatel pracuje s vaším software ✅
<ul>
<li>JavaDoc i další komentáře jsou dostupné ve všech třídách</li>
</ul>

Dvě různé konfigurace domu a pro ně vygenerovány reporty za různá období. ✅
<ul>
<li>Vytvoril jsem 3 konfigurace (house/HouseFactory.java) a je mozne je pouzit pomoci zakomentovani a odkomentovani radku (16,18,20) v souboru SmarHome.java</li>

<li>Reporty se generuji podle vybrane konfigurace</li>
<ul>
