# Raportit tehtävistä

Kirjaa tähän tiedostoon **jokaiseen** tehtävään liittyvät omat raporttisi ja analyysisi. Muista että raportti on myös kurssilla **arvosteltava tehtävä**.

Voit sisällyttää raporttiin tekstimuotoisia taulukoita (tasaukset välilyönnein):

```
n     Fill     Search   Total
500   7        700      707
1000  9        288      297
```

Ja näihin liittyviä kuvatiedostoja:

![Esimerkkikuva](report-sample-image.png)

Nämä näkyvät sitten VS Coden Preview -näkymässä (tai oman repositorysi webbisivulla) oikein muotoiltuna. Käytä tässä dokumentissa olevia muotoiluja esimerkkinä kun kirjoitat raporttiasi. 

Huomaa että jos laitat kuvatiedostot vaikka omaan alihakemistoonsa, Markdown -muotoilussa on oltava suhteellinen polku tiedostoon, esimerkiksi `images/report-sample-image.png`. **Älä** käytä absoluuttisia polkuja `C:\Users\tippaleipa\kurssit\TIRA\kuva.png`, koska nämä eivät tietenkään toimi opettajan koneella. Ei kannata laittaa linkkiä etärepoosikaan, vaan nimenomaan paikalliseen tiedostoon.

Voit myös sisällyttää *lyhyitä* koodinpätkiä vaikkapa Java -formaatilla:

```Java
	@Override
	public int hashCode() {
		// Oma nerokas hajautufunktioni!
	}
```
Tarvittaessa käytä myös paremmin muotoiltuja taulukoita:

| n	| Fill	| Search	| Total |
|-----|--------|--------|-------|
| 500	 | 7	| 700	| 707 |
| 1000 |	9	| 288	| 297 | 

Alaluvut jokaisen tehtävän raportille löydät alta.


## 01-TASK

Tehtävä toimi hyvänä kertauksena java ohjelmoinnista, sillä kesän aikana koodia tuli kirjoitettua aivan liian vähän. Pienen alkukankeuden jälkeen (varsinkin geneerisen ohjelmoinnin muistelussa), ei tehtävän suorittamisessa suurempia haasteita tullut vastaan. Ohjelmointi 2 kurssin aikana geneerinen ohjelmointi jäi melko vähäksi, joten se vaati kohdallani erityistä kertaamista. 

Toteutin student hakemistoon oman luokan MyClass.java, johon on tarkoitus kirjoittaa omia apumetodeita. Toteutin luokkaan algoritmin

```Java
	public static <T> void swap (T[] array, int first, int second) {

        T temp = array[first];

        array[first] = array[second];
        array[second] = temp;
    } 
```

Käytin swap metodia apuna sekä lisäyslajittelu-, että kääntämisalgoritmeissä. Swap- metodin vuoksi minun ei tarvinnut kirjoittaa samoja koodirivejä uudelleen.

Toteuttamani lajittelualgoritmin aikakompleksisuusluokka on O(n^2), sillä algoritmi sisältää sisäkkäin for loop:in ja while silmukan, jotka kummatkin käyvät läpi taulukon aineiston.

Reverse algoritmi käy läpi taulukon elementit puoleenväliin asti. Aikakompleksisuusluokka tällä metodilla on O(n), koska siinä on vain yksi while-silmukka, joka käy läpi taulukon.

Mikäli taulukko on valmiiksi järjestyksessä nousevaan järjestykseen, kannattaa sen järjestys kääntää uudelleen järjestämisen sijaan. 

Kääntämisen aikakompleksisuusluokka on O(n), koska se käy taulukon läpi vain kerran. Uudelleenlajittelun aikakompleksisuus on pahimmassa tapauksessa O(n^2). Vaikka lajittelu voi parhaimmassa tapauksessa saavuttaa O(n) aikakompleksisuuden, on kääntäminen aina vähintään yhtä tehokasta kuin uudelleenlajittelu
 

## 02-TASK

Tehtävän 2 tekemisessä ei suurempia haasteita tullut vastaan, ja rutiini ohjelmointiin tuntuu palautuvan. Tehtävän askeleet olivat hyvin ohjeistettuja ja koodiin pääsi nopeasti kiinni. 

SimpleContainer.add metodi käy läpi taulukkoa löytääkseen sijoituspaikan parametrinä saamaalleen elementille. Metodi tarkistaa, ettei taulukossa ole elementtiä jo valmiiksi, jotta duplikaateilta elementeiltä vältytään. Jos elementtiä ei ennaltaan ole taulukossa, se lisätään taulukon loppuun.

Mikäli taulukon koko on loppumassa kesken, metodi uudelleenallokoi taulukon muistin kaksinkertaiseksi. On järkevää allokoida muistia kerrallaan reilusti, jotta allokointia tarvitsisi tehdä mahdollisimman harvoin. Tämä johtuu siitä, että muistin uudelleenallkointi on hidasta.

Metodi käy taulukon läpi kertaalleen ja sen aikakompleksisuus on lineaarinen taulukon koon suhteen. Näin ollen metodin aikakompleksisuusluokka on lineaarinen O(n).


Myös tehtävässä toteuttamani hakualgoritmit E get(E element), int indexOf(E element, Comparator<E>), int findIndex(Predicate <E>) ja E find(Predicate<E>) ovat aikakompleksisuudeltaan lineaarisia O(n), sillä ne käyvät taulukon indeksit läpi yksi kerrallaan, ja suoritusaika riippuu suoraan verrannollisesti taulukon koosta.


![kuva](task-02-searchPerformance.png)

Kuvasta näkee, että S eli hakuajat nousevat lineaarisesti. Täyttöajat kasvavat selvästi eksponentiaalisesti. Tämä johtuu siitä, että taulukon täyttyessä allokoidaan muistia tuplasti enemmän. Näinollen allokoitava muistin määrä kasvaa eksponentiaalisesti ja taulukon täyttö hidastuu.

Tira Coders Logissa huomataan varsinkin suurilla tietomäärillä, että eri algoritmien suoritusajat vaihtelevat huomattavasti. Erityisesti kokonimen sekä koodarinimen lajittelu on hidasta insertionSort metodin takia. Kyseisen metodin aikakompleksisuus on neliöllinen O(n^2), joten se on hidasta. Järjestyksen kääntäminen tapahtuu nopeasti, sillä se hyödyntää reverse metodia, joka on lineaarinen O(n).

Tästä syystä alkioiden järjestyksen vaihtaminen päinvastaiseksi on tehokkaampaa tehdä kääntämällä, kuin lisäyslajittelua hyödyntämällä, sillä kääntämisen aikakompleksisuus on aina vähintään yhtätehokasta lajitteluun verrattuna.

## 03-TASK

Tässä tehtävässä toteutin puolitushakualgoritmin rekursiivisesti sekä iteratiivisesti ja lisäsin metodeille tarvittavat kutsut valmiisiin metodeihin. Molemmat toteutukset toteutin käyttäen sekä Comparable, että Comparator rajapintaa. Eri rajapintojen välillä metodit ovat hyvin lähellä toisiaan, sillä eroavaisuus on lähinnä vain vertailun kutsuissa.
Lopuksi täydensin SimpleContainer.indexOf(E, Comparator<E>) metodia siten, että taulukon ollessa lajiteltu, se kutsuu nopeampaa puolitushakua lineaarisen haun sijaan.

Toteuttamissani puolitushakualgoritmien silmukoissa taulukko jaettiin joka kerta puoleen, jolloin aikakompleksisuudeksi saatiin logaritminen O(log n)

Comparatoria käyttäessä pienenä haasteena ilmeni yhtäsuuruuden vertailu, sillä Comparatorin equals metodi ei toiminut odottamallani tavalla. Tämä ongelma ratkesi, kun otin selvää metodin toiminnasta Comparator rajapinnan dokumentaatiosta.

Lopulta käytin yhtäsuuruuden vertailuna compare metodia. Compare metodin palauttaessa nollan elementit ovat yhtäsuuria.

**Hakujen kokeilu ja analyysi**

Kokeilin askel 3 ohjeiden mukaan hakea TIRA Coder sovelluksella koodareita nopealla ja hitaalla haulla. Suoritin hakuja listan alusta sekä keskeltä, että lopusta.

Hitaassa haussa (haku ilman exact searchia) huomasin, että mitä lähempänä listan alkua on, sitä nopeampia hakuajat ovat. Listan ensimmäisten joukossa olevien koodarien hakuun aikaa meni vain 0-1 ms, keskivaiheilla olevan koodarin hakuun kesti noin 6 ms, ja listan viimeisenä olevan koodarin hakuun menikin jo 17 ms.

Tämä ilmiö johtuu siitä, että järjestelmän perushaku suoritetaan lineaarisella haulla. Eli käytännössä hakuaika kasvaa lineaarisesti suhteessa aineiston kokoon.

Exact searchia käyttäessä hakuajaksi saatiin 0ms joka hakukerralla, mikä tarkoittaa sitä, että hakuaika oli niin pieni, että se pyöristyi nollaan. Exact search käyttää tässä tehtävässä luotua puolitushakua, joka näyttäisi olevan selvästi tehokkaampi, kuin lineaarinen haku. Lisäksi puolitushakua käyttäessä hakuaikaan ei vaikuta se, että missä vaiheessa taulukkoa haettava koodari on.

Tämä huomio on tärkeä, sillä puolitushaun tulisi teoriassakin olla tehokkaampi, kuin lineaarisen haun, sillä sen aikakompleksisuus on logaritminen. O(log n) siis osoittautuu tehokkaammaksi, kuin lineaarinen O(n).

**Täytön, järjestämisen ja puolitushaun suoritusajat**
![kuva](task-03-binSearchGraph.png)

Kuvaajassa esitetään käyrät täytölle(fill) ja järjestämiselle(sort) millisekunteina, sekä puolitushaulle (search) mikrosekunteina.

Jos kuvaajan hakuaikoja vertaa edellisen tehtävän vastaavaan kuvaajaan, huomataan, että hakuajat ovat selvästi pienemmät. Hakuajan alussa oleva aikapiikki johtuu ohjelman kääntämisesta, tietokoneen toiminnasta testiä aloittaessa ja testiin valmistautumisesta. 

Edelliseen tehtävään verrattaessa huomataan, että puolitushaun kuvaajassa on lisäksi sort käyrä, jota lineaarisessa haussa ei ole. Tämä johtuu siitä, että puolitushakua käytettäessä on ehdoton vaatimus, että aineisto on lajiteltu. Lineaarinen haku tomii myös lajittelemattoman aineiston kanssa, jolloin lajitteluun ei kulu aikaa.

Puolitushaun käyttöehtona on se, että taulukko on valmiiksi lajiteltu. Tämä johtuu puolitushaun toimintaperiaatteesta, sillä se hyödyntää taulukon järjestystä vertaillessaan, onko haettava arvo suurempi vai pienempi, kuin taulukon keskikohta.

Edellisessä tehtävässä toteutettu lineaarinen haku toimii myös lajittelemattoman aineiston tapauksessa, sillä se käy haettavat arvot läpi yksitellen.

Tehokkuudensa ansiosta puolitushakua kannattaa käyttää lineaarisen haun sijaan, mikäli aineisto on lajiteltu. Esimerkkinä tästä tilanteesta on mainitsemani SimpleContainer.indexOf metodi, joka tarkistaa onko taulukkoa lajiteltu. Mikäli on, kutsutaan puolitushaku ja muussa tapauksessa käytetään lineaarista hakua.


## 04-TASK

Tässä tehtävässä toteutin pino rajapinnan StackInterface omaan toteutusluokkaani StackImplementation. Lisäksi hyödynsin toteutettua pinoa toteuttamalla sulkeidentarkistus algoritmin ohjeiden mukaisesti.

Tehtävässä vaikeinta oli poikkeuksien käsittely, sillä sen harjoittelu on ollut kohdallani liian vähäistä. Tätä tehtävää tehdessä sain hyvää kertausta poikkeusten heittämisen sekä käsittelyyn liittyen. Live luennon poikkeuksia koskevan kertauksen avulla sain paljon oppia aiheeseen liittyen.

Myös StringBuilderin käyttöön liittyen kertaaminen oli tervettullutta, sillä aiemmin olen toteuttanut toString() metodit String luokkaa hyödyntäen. Tehtävässä opin, että StringBuilderin käyttö on todella paljon tehokkaampaa aiemmin käyttämääni toteutukseen verrattuna.


Pino toteutukssani seurasin tarkasti ohjeita ja se vastaakin tehtävänannon aikakompleksisuusvaatimuksia. Metodit ovat aikakompleksisuudeltaan vakioita, lukuunottamatta push(), mikäli joudutaan reallokoimaan ja toString(). Nämä kaksi ovat aikakompleksisuudeltaan lineaarisia.

Toteutuksessani on kolme yksityistä jäsenmuuttujaa: 
Object[] itemarray - tietorakenteen sisäinen taulukko

int top - muuttuja, joka kertoo indeksin, johon viimeisin elementti on lisätty

int DEFAULT_STACK_SIZE = 20 - taulukon oletuskoko

**Muodostimet**

Pino toteutuksessani on kaksi muodostinta: parametriton ja parametrillinen

Parametriton yksinkertaisuudessaan luo pinon taulukon oletuskapasiteetin kokoiseksi ja alustaa top muuttujan arvoon -1.


Parametrillinen saa parametrina taulukon koon.
Tämä versio tarkistaa, että parametrinä saatu koko on suurempi, kuin 0. Mikäli tämä ei toteudu parametri heittää poikkeuksen
IllegalArgumentException("Stack size must be greater than 0.").
Jos parametrina saatu koko on oikeellinen, luodaan pinon taulukko annetun kokoiseksi ja alustetaan top muuttuja arvoon -1.


Top muuttuja asetetaan arvoon -1, koska se indikoi, että pino on tyhjä.

**Metodit**

**capacity()**
Aikakompleksisuus O(1)

Metodi ainoastaan palauttaa pinon sisäisen taulukon koon, joten se ei sisällä silmukoita tai vaihtelevia input aineistoja.
Metodi suoritetaan aina vakioajassa, joten sen aikakompleksisuus on O(1).

**push(E element)**
Aikakompleksisuus O(n)

Puskuoperaatio itsessään on aikakompleksisuudeltaan vakio O(1), sillä se ainoastaan lisää uuden elementin taulukon top indeksiin ja kasvattaa top-arvoa yhdellä, jos elementti ei ole tyhjä (null). Jos elementti on tyhjä metodi heittää poikkeuksen NullPointerException("Push must not be null.").

Kuitenkin mikäli taulukko on täynnä, joudutaan lisäämään taulukon kokoa. Taulukon reallokointi edellyttää sen jokaisen elementin läpikäymistä ja kopioimista uuteen taulukkoon silmukassa, jolloin aikakompleksisuus on lineaarinen O(n).

Parhaimmillaan metodin aikakompleksisuus on O(1), mutta pahimmassa tapauksessa taulukon ollessa täynnä aikakompleksisuus on O(n).

**pop()**
Aikakompleksisuus O(1)

Metodi poistaa pinosta päälimmäisen elementin, jos pino ei ole tyhjä ja vähentää top-arvoa yhdellä. Jos pino on tyhjä metodi heittää poikkeuksen
IllegalStateException("Cannot pop from an empty stack.")
Metodissa ei ole vaihtelevaa inputin kokoa eikä silmukoita, joten sen suoritusaika on aina vakio O(1).

**peek()**
Aikakompleksisuus O(1)

Peek metodi palauttaa pinosta päälimmäisen elementin poistamatta sitä pinosta. Mikäli pino on tyhjä metodi heittää poikkeuksen IllegalStateException("Cannot peek from an empty stack.").
Metodin suoritusaika on aina vakio, sillä metodilla ei ole syötettä, josta se olisi riippuvainen, eikä toteutuksessa ole silmukoita.

**size()**
Aikakompleksisuus O(1)

Size metodin ainoa toiminto on palauttaa kutsujalle pinon reaaliaikainen koko. Suoritusaika on vakio, koska metodin suoritusaika ei riipu minkään syötteen koosta, eikä metodissa ole silmukoita.

**isEmpty()**
Aikakompleksisuus O(1)

Metodi tarkistaa onko pino tyhjä vai ei. Mikäli top-muuttujan arvo on -1, pino on tyhjä ja metodi palauttaa true. Muussa tapauksessa palautetaan false, sillä pino ei ole silloin tyhjä. 

Metodi ainoastaan palauttaa boolean-arvon kutsujalle, eikä siinä ole silmukoita ja se ei ole riippuvainen minkään aineiston koosta, joten suoritusaika on vakio.

**clear()**
Aikakompleksisuus O(1)

Tyhjennysmetodi luo pinon sisäisen taulukon tilalle uuden tyhjän taulukko olion, jonka koko on attribuuteissa määritelty vakio. Myös top-muuttujan arvoksi asetetaan -1, sillä taulukko on nyt tyhjä.

Metodi ei iteroi taulukon elementtien läpi, vaan se suoraan alustaa taulukon tilalle uuden tyhjän taulukon. Tällöin ei tarvita silmukoita ja suoritusaika on aina vakio.

**reallocate(int newSize)**
Aikakompleksisuus O(n)

Metodia ei ollut rajapintaluokassa, mutta toteutin sen apumetodiksi push() metodille pitääkseni koodin siistimpänä.

Metodi kopioi pinon sisäisen taulukon elementit uuteen suurempaan taulukkoon ja korvaa pinon sisäisen taulukon uudella suuremmalla taulukolla.

Koska taulukon kaikki elementit tulee käydä kopioitaessa läpi, metodin aikakompleksisuus on O(n). Metodin suoritusaika riippuu taulukon elementtien määrästä.

Tämä metodi kutsutaan tarvittaessa push() metodista, joka aiheuttaa sen, että push metodin aikakompleksisuus on huonoimmassa tapauksessa myös O(n).

**toString()**
Aikakompleksisuus O(n)

toString metodin aikakompleksisuus on O(n), koska metodissa käydään läpi kaikki pinon sisäisen taulukon elementit, jotta niistä voidaan muodostaa merkkijono.
Suoritusaika määräytyy pinon taulukon elementtien määrästä, joten aikakompleksisuus on O(n).

**ParenthesisChecker**
Toteurin sulkeidentarkistusalgoritmin arvosanan 2 tasolle. Tämän algoritmin tarkoituksena on tarkastella tekstin sulkumerkkejä ja erityisesti niiden oikeellisuutta. Toteutin myös toiminnallisuuden, jossa sulkuja ei käsitellä mikäli ne ovat lainausmerkkien sisällä.

Tämän checkParenthesis algoritmin aikakompleksisuus on lineaarinen O(n), jossa n on tekstin koko, josta sulkujen oikeellisuutta tarkistetaan. Algoritmissä on sisäkkäin kaksi silmukkaa, mutta aikakompleksisuus pysyy lineaarisena, sillä jokainen kirjain käydään kerran läpi joko for silmukassa, tai sisemmässä do-while loopissa. Tämä johtuu siitä, että mikäli vastaan tulee lainausmerkki, käydään ennen seuraavaa lainausmerkkiä tulevat merkit läpi pelkästään do-while silmukassa. Mikäli ei olla sulkumerkkejen välissä, iteroidaan pelkästään for silmukalla.


## 05-TASK

Tehtävässä toteutin jono tietorakenteen käyttämällä sekä taulukkoa, että linkitettyä listaa. Loin toteuttamistani jonoista myös olit factory-luokkiin, jolloin jono toteutus on käytössä Tira Coders sovelluksessa sekä testeissä. Kokeilin sovelluksessa sekä taulukkopohjaista, että linkitetyllä listalla toimivaa jonoa.

Tässä tehtävässä opin ymmärtämään jono tietorakenteen periaatteen, sekä opin hyödyntämään sitä käytännössä. Linkitetty lista oli täysin uutta asiaa ja sen ymmärtäminen vaati paljon työtä sekä aikaa. 

Taulukkototeutuksessa metodit 
capacity(), dequeue(), element(), size(), isEmpty() sekä clear() toteuttivat vaaditun vakio aikakompleksisuuden O(1). Näiden metodien suoritusaika on vakio, sillä se ei ole riippuvainen syötteen koosta, eivätkä ne sisällä silmukoita.

Metodi enqueue() on parhaassa tapauksessa O(1), mutta mikäli taulukkoa joudutaaan kasvattamaan, kutsutaan reallocate(int) metodia, jonka aikakompleksisuus on O(n). Metodi enqueue() on siis pahimmassa tapauksessa aikakompleksisuudeltaan lineaarinen O(n).

Metodissa toString iteroidaan taulukon elementit läpi, jolloin sen suoritusaika on riippuvainen taulukon koosta, joten sen aikakompleksisuus on O(n). Parhassa tapauksessa, mikäli taulukko on tyhjä, päästään toString metodissa aikakompleksisuuteen O(1).


Linkitettyä listaa käytettäessä uudelleenallokointia ei tarvitse tehdä, koska listan muistipaikkoja ei tarvitse varata erikseen, jolloin listalla ei ole ennalta määritettyä kapasiteettiä. Tästä syystä linkitetyn listan toteutuksessa ei tarvita muistin uudelleenallokointia ja kaikki metodit ovat aikakompleksisuudeltaan vakioita O(1), paitsi toString O(n), jossa käydään lista läpi solmu kerrallaan. 

**Linkitetty lista vs taulukko**

**muistitehokkuus**
Linkitettyä listaa käytettäessä jokaisen alkion yhteyteen täytyy tallentaa viittaus seuraavaan solmuun, jota taulukkopohjaisessa ei tarvitse tehdä. Linkitetty lista vie siis hieman enemmän muistia per alkio verrattuna taulukkoon.

Taulukkopohjaisessa toteutuksessa elementit ovat muistissa peräkkäin ja linkitetyn listan tapauksessa elementit eivät ole muistissa järjestettynä. Tämä voi hidastaa algoritmin toimintaa käytettäessä linkitettyä listaa. Taulukosta voidaan myös palauttaa indeksin avulla haluttu elementti vakioajassa, kun taas linkitetyn listan tapauksessa joudutaan käymään lista läpi solmu kerrallaan mikäli halutaan saada listalta tietty alkio.

**aikatehokkuus**
Taulukkopohjaisessa toteutuksessa joudutaan lisäämään taulukon kapasiteettiä taulukon tilan loppuessa, jolloin aikakompleksisuus kasvaa lineaariseksi. Linkitetyn listan tapauksessa uudelleenallokointia ei tarvitse tehdä. 


Taulukkopohjainen toteutus on parempi tilanteissa, joissa tietorakenne on harvoin muuttuva ja tarvitaan tehokasta muistin käyttöä.

Linkitetty lista on parempi tilanteissa, joissa elementtejä lisätään tai poistetaan usein, eikä etukäteen tiedetä paljonko muistia tulisi varata.

## 06-TASK

Tässä tehtävässä toteutin kolme nopeaa lajittelualgoritmia quickSort, mergeSort sekä heapSort. Muokkasin myös SimpleContainer luokan sort metodeja, jotta nopeat lajittelualgoritmit toimivat myös Tira Coders sovelluksessa.
En ollut aiemmin toteuttanut ollenkaan nopeita lajittelualgoritmejä, joten aloitin tehtävän tutustumalla algoritmien toimintaan luentomateriaalien sekä wikipedian avulla. QuickSort sekä mergeSort olivat hyvää harjoitusta rekursiivien algoritmien toteuttamisessa. Rekursiivisuuden ymmärtäminen ja hyödyntäminen on ollut ajoittain vaikeaa, joten harjoitus on hyväksi.

**Quicksort**

Aikakompleksisuus: keskimääräinen O(n log n)

Huonoin tapaus: O(n^2)

Muistikompleksisuus O(log n)

Ensimmäisenä toteutin quickSort algoritmin hyödyntäen Hoaren partitiointimenetelmää. Käytin partitioinnissa pivot arvon valintaan toteuttamaani medianOfThree algoritmiä, joka valitsee pivot arvoksi taulukon ensimmäisen, keskimmäisen sekä viimeisen elementin mediaanin. Tämä vähentää todennäköistyyttä sille, että pivot arvoksi valikoituu taulukon pienin tai suurin arvo, jolloin aikakompleksisuus voisi nousta neliölliseksi.


QuickSort algoritmin keskimääräinen aikakompleksisuus on O(n log n), sillä quickSort metodi jakaa syötteenä saadun taulukon kahteen osaan rekursion joka vaiheessa, minkä vuoksi algoritmin päämetodin aikakompleksisuudeksi tulee O(log n).

Algoritmin apumetodi hoarePartition on aikakompleksisuudeltaan O(n), sillä se käy taulukon läpi silmukassa elementti kerrallaan. Partitioinnissa käytetty metodi medianOfThree on aikakompleksisuudeltaan vakio O(1), sillä sen suoritusaika ei vaihtele aineiston mukaan eikä siinä ole silmukoita. MedianOfThree ei siis vaikuta algoritmin aikakompleksisuuteen. 

Yhdistämällä nämä apumetodit päämetodiin, tulee quick sort algorimtin keskimääräiseksi aikakompleksisuudeksi O(n log n).

Pahimmassa tapauksessa, jos syötteenä saatu taulukko on lähestulkoon tai kokonaan lajiteltu ja pivot arvoksi on valittu taulukon ensimmäinen tai viimeinen elementti, quicksort algoritmi ei pysty jakamaan taulukkoa tasaisesti kahteen osaan. Tällaisessa tilanteessa algoritmi joutuu käsittelemään jokaisessa tasossa lähes kaikki elementit uudelleen ja aikakompleksisuudeksi nousee O(n^2). 

Käyttämäni partitiointimetodi pyrkii estämään tällaisia tilanteita valitsemalla kolmesta arvosta keskimmäisen.

![kuva](insertionSort-vs-quickSort.png)

Testien aikamittauksien avulla huomataan ero quickSortin O(n log n) ja aiemmin toteuttamani hitaan lajittelualgoritmin insertionSortin O(n^2) suorituskyvyssä. Kuvan sininen käyrä edustaa tässä tehtävässä toteuttamaani pikalajittelua, joka on selkeästi nopeampi varsinkin suurilla aineistoilla. 

Erot suorituskyvyssä kävi myös ilmi Tira Coders sovelluksessa, sillä muistiin lataaminen ja lajittelu 50000 koodarin aineistolla vaati hidasta lajittelua käyttämällä 2 min 32sek. Quicksorttia käyttämällä vastaava operaatio samalla aineistolla kesti vain 34 sekuntia. Operaatio on edelleen hidas, sillä puolen minuutin odottelu tuntuu käyttäjän näkökulmasta pitkältä ajalta, mutta selvästi nopeampi kuin hidasta lisäyslajittelua käyttämällä. 

Operaation hitaus johtuu SimpleContainerin add() metodista, sillä se käy lisättävät elementit yksitellen läpi.


**Mergesort**

Aikakompleksisuus O(n log n)

Muistikompleksisuus O(n)

Toinen toteuttamani nopea lajittelualgoritmi mergesort perustuu myös rekursiiviseen hajota ja hallitse periaatteeseen.

Mergesortin toiminta perustuu siihen, että se jakaa taulukon keskeltä kahtia joka rekursion vaiheessa kutsumalla rekursiivisesti mergesort algoritmiä, kunnes taulukon osa sisältää vain yhden elementin. Taulukon jakaminen kahteen osaan joka rekursion vaiheessa tekee mergesort metodin aikakompleksisuudesta O(log n), sillä jakamisvaiheiden määrä on verrannollinen syötteen kokoon logaritmisesti.

Tämän jälkeen taulukon osat yhdistetään merge() metodilla siten, että ne ovat kokonaisessa taulukossa järjestyksessä.

Toisin kuten quickSort algoritmissä, merge metodi luo kaksi aputaulukkoa, jotka täytetään alkuperäisen taulukon arvoilla. Nämä taulukot sisältävät alkuperäisen taulukon puolikkaat. Merge metodi vertailee aputaulukoiden arvoja yksi kerrallaan toisiinsa ja sijoittaa pienemmän arvon alkuperäiseen taulukkoon. Mikäli toinen taulukko loppuu aiemmin, merge metodi täyttää loput lajitellusta taulukosta jäljellä olevista aputaulukon arvoista. Tämä toimenpide varmistaa sen, että jokainen elementti tulee lajitelluksi.

Merge metodin aikakompleksisuus on O(n), sillä taulukoiden elementit käydään yksitellen läpi. Yhdistämällä nämä kaksi metodia tulee algoritmin aikakompleksisuudeksi O(n log n).

Aputaulukoiden käyttö tekee algoritmistä muistitehokkuudeltaan raskaamman, kuin "in place" periaatteella toimivan quicksortin. Tämä voi olla ongelma järjestelmissä, joissa vaaditaan tehokasta muistin käyttöä. Kuitenkin mergesort on aikakompleksisuudeltaan aina O(n log n), toisin kuin quicksort, jonka aikakompleksisuus voi pahimmassa tapauksessa nousta neliölliseksi. 


**Heapsort**

Aikakompleksisuus O(n log n)

Muistikompleksisuus O(1)

Viimeinen tehtävässä toteuttamani algoritmi heapSort eli kekolajittelu eroaa muista tehtävän nopeista lajittelualgoritmeistä siten, että se ei ole rekursiivinen algoritmi.

Heapsort perustuu siihen, että lajiteltavasta taulukosta muodostetaan puumainen kekorakenne, joka järjestellään maksimikeoksi. Tämä tarkoittaa sitä, että ylemmän solmun arvo on aina suurempi tai yhtä suuri, kuin sen lapsisolmun arvo. Kun on saatu aikaan maksimikeko, asetetaan suurin elementti taulukon loppuun ja muodostetaan uudelleen maksimikeko. Uudesta maksimikeosta lisätään taulukkoon alkuun suurin elementti, ottamatta huomioon jo lisättyjä elementtejä. Tällöin taulukkoon lisätyt arvot ovat järjestyksessä, kun kaikki elementit on siirretty puusta taulukkoon.

Algoritmin ensimmäisessä vaiheessa kutsutaan heapify metodia, joka muodostaa taulukosta maksimikeon siftDown metodin avulla. Siftdown metodin aikakompleksisuus on O(log n) sillä sen suoritusaika on riippuvainen puun korkeudesta. Heapify algoritmin aikakompleksisuus on O(n), sillä siinä käydään läpi vain isäntäsolmut, eli ne solmut joilla on lapsisolmuja.

Kun maksimikeko on saatu rakennettua, siirretään suurin arvo taulukon alusta taulukon loppuun ja vähennetään heapsort algoritmin end-muuttujan arvoa. Kun end-arvoa vähennetään, ei suurin arvo enää ole mukana lajittelussa. Lopuksi kutsutaan siftDown metodia palauttamaan kekorakenteen oikeellisuus. 
Tätä prosessia suoritetaan iteratiivisesti, kunnes kaikki arvot ovat lajiteltu.

Algoritmin aikakompleksisuus on O(n log n), sillä heapify metodin aikakompleksisuus on O(n) ja siftDown metodin aikakompleksisuus on O(log n). Heapsort metodin suoritusaika on suoraan riippuvainen taulukon koosta, sillä jokainen elementti lajitellaan ja jokaisessa vaiheessa kutsutaan siftDown, joten kokonaisaikakompleksisuus on O(n log n).


**Nopeiden algoritmien vertailu**

![kuva](fastSorts-kuvaaja.png)

Suoritin aikamittaukset jokaisella nopealla lajittelualgoritmillä, jotta niitä voidaan vertailla keskenään.

Tehtävässä jokainen toteuttamani lajittelualgoritmi on aikakompleksisuudeltaan O(n log n). Poikkeuksena quickSortin huonoin tapaus, jossa sen aikakompleksisuus voi nousta O(n^2).

Kuvaajasta käy ilmi, että pienillä aineistoilla suoritusajat ovat hyvin lähellä toisiaan, mutta aineistojen kasvaessa eroja syntyy jonkin verran.
Aikamittausten perusteella testeissä parhaiten suoriutui oranssilla kuvattu mergeSort. Hitain suoritus oli heapSort algoritmillä, joka oli kahta muuta selkeästi hitaampi. 

Mergesortin nopeus voidaan selittää sillä, että käytetyssä testikoneessa on paljon muistia käytössä, jolloin algoritmin ylimääräinen muistinkäyttö ei rajoita suorituskykyä. Mergesort luo aputaulukoita ja taulukoissa elementit ovat peräkkäisissä muistipaikoissa, jolloin tiedon käsittely on nopeampaa. Tällöin sovellus hyödyntää tehokkaasti tietokoneen välimuistia ja suorituskyky parantuu eteenkin suurilla aineistoilla. Ylimääräinen muistinkäyttö voi kuitenkin haitata suorituskykyä, mikäli käytettävissä ei olisi tarpeeksi välimuistia tai muisti on hidasta.

Heapsortin hitaus johtuu todennäköisesti sen ylläpitämästä kekorakenteesta, jossa elementit eivät ole muistissa peräkkäin. Tämä voi hidastaa algoritmin suorituskykyä eteenkin suurilla aineistoilla, kun kekoa päivitetään usein (esimerkkinä siftDown metodi).


## 07-TASK

Tämä tehtävä oli ensikosketukeni binäärisiin hakupuihin, joten tehtävän tekeminen alkoikin syvällisellä tiedonhaulla. Luentojen lisäksi perehdyin puutietorakenteisiin Geeks for geeks nettisivun sekä wikipedian avulla. Puutietorakenteen toimintaperiaate oli aluksi hieman vaikea ymmärtää, sillä sekoitin sen aiemmin käytetyn heapin eli keon kanssa. Kuitenkin pian hoksasin binäärisen hakupuun perusperiaatteen ja pääsin tehtävän koodaamisessa alkuun liveluentojen demojen avulla. Tein harjoituksen vuoksi eri metodeissa puun läpikäyntiä rekursiivisesti sekä iteratiivisesti. Tässä tehtävässä helpommin ymmärrettävä tapa puun läpikäynnissä oli mielestäni rekursiivinen läpikäynti. Ennen kurssin alkua rekursiivisuus tuntui jokseenkin abstraktilta ja vaikeasti hahmoteltavana asiana, mutta kurssin aikana olen oppinut ymmärtämään ja hyödyntämään rekursiivisia algoritmejä.

Avain-arvo parien konsepti oli mielestäni helppo ymmärtää, vaikka ennen tätä tehtävää niitä ei olla liiemmin käsitelty. Tällainen avain arvo parien käyttäminen on mielestäni todella kätevä tapa käsitellä arvoja, jotka tunnistetaan tietyn avainarvon perusteella. Kuitenkin pieniä haasteita avain-arvo parien käyttämisessä oli. Haasteina koin tällaisen avain-arvo pari taulukon luomisen, eteenkin taulukon saaminen oikean tyyppiseksi oli epäintuitiivista. En saanutkaan alustettua Pair<K,V> taulukoita ilman, että editori liputtaisi tällaisen tyyppimuunnoksen. Mielestäni taulukon tietotyypit ovat oikeat ja tyyppimuunnokset turvallisia sekä odotettuja, joten käytin taulukoiden luomiseen suppress warning toimintoa.

**Algoritmien oikeellisuus ja aikakompleksisuus**

Tehtävässä aikakompleksisuuksien sekä oikeellisuuden arviointi oli haasteellisempaa, kuin aiemmin sillä tehtävässä ei annettu erikseen algoritmeille aikakompleksisuusvaatimuksia, vaan ne piti päätellä itse teorian sekä testien pohjalta.

Kerron alla kustakin algoritmistä toimintaperiaatteen, aikakompleksisuuden ja osasta algoritmeistä vertailua taulukkopohjaiseen simpleContaineriin nähden.

**add(K key,V value)**

Add metodissa parametrinä tuleva avain arvo pari lisätään puuhun, mikäli kumpikaan arvoista ei ole Null. Algoritmi tarkistaa ensin puun juurisolmun, ja mikäli se on tyhjä asetetaan annettu pari suoraan juurisolmuun puun ensimmäiseksi elementiksi. Mikäli puussa on jo elementtejä, kutsutaan rekursiivista TreeNode luokan insert() metodia.

Insert algoritmi rekursiivisesti asettaa uuden avaimen puuhun vasemmalle alipuuhun, mikäli avain on pienempi tai yhtä suuri kuin nykyinen avain.
Mikäli avain on suurempi, kuin nykyinen avain, se lisätään oikeaan alipuuhun. Algoritmi käy puuta läpi näillä ehdoilla ja lisää parametrinä tulleen avain-arvo parin oikeelliseen kohtaan alimpaan solmuun.

Insert metodi huolehtii myös puun maksimisyvyyden laskemisesta. Mikäli arvoja lisätessä maksimisyvyys ylittää BSTContainer luokassa olevan maxDepth arvon, päivitetään nykyinen puun syvyys maksimisyvyydeksi.


Add algoritmin aikakompleksisuus parhaassa tapauksessa on O(log n), sillä insert metodi kulkee puun läpi askel kerrallaan, eli suoritusnopeus on riippuvainen puun syvyydestä. Tämä paras tapaus saavutetaan, mikäli puu on täysin tasapainossa, eli vasen ja oikea alipuu ovat yhtä syviä. Aikakompleksisuus O (log n) tulee siitä, että jokaisella tasolla verrataan alkiota oikean ja vasemman alipuun kanssa, ja aina siirryttäessä seuraavalle tasolle tutkittavien solmujen määrä puolittuu.

Huonoimmassa tapauksessa puu voi degeneroitua linkitetyksi listaksi. Tämä tapahtuu silloin, jos puun juurisolmu on pienin tai suurin ja muut solmut lisätään järjestyksessä. Tästä syystä Tira codersinkin taulukko sekoitetaan, eikä lisätä oikeassa järjestyksessä uuteen binääriseen hakupuuhun. Tällaisessa huonoimmassa tapauksessa algoritmin aikakompleksisuus on O(n), sillä puun jokainen alkio joudutaan käymään läpi.

Mikäli puussa ei ole vielä yhtään avain arvo paria, lisätessä algoritmin aikakompleksisuus on O(1), sillä pari lisätään suoraan puun juurisolmuun.


**Add BST vs SimpleContainer**

![kuva](BST-add.png)
![kuva](SC-add.png)

Kuten kuvista ja algoritmien lähdekoodia analysoimalla huomataan, SimpleContainerin add on lineaarinen O(n), sillä ennen lisäämistä algoritmissä tarkastetaan, ettei taulukkoon lisätä duplikaatteja elementtejä. Tämän tarkistamiseksi algoritmissä käydään jokainen alkio läpi, jolloin suoritusaika on riippuvainen taulukon koosta. Tämä näkyy alemmassa kuvaajassa lineaarisena käyränä.

Kuten yllä huomattiin BST add metodi taas on logaritminen O(log n). Kuvaajasta huomataankin logaritmisia piirteitä, sillä alkioiden määrän kasvaessa suureksi suoritusajan kasvu hidastuu maltilliseksi.

Teoriaan pohjautuen sekä kuvaajia katsomalla voidaan todeta BST toteutuksen olevan selvästi tehokkaampi. Esimerkiksi 100000 alkion aineistolla lisäämiseen kului aikaa SimpleContainer toteutuksella kesti noin 3,5 minuuttia, kun taas BST ratkaisulla saman operaation suorittamiseen kului vain 7ms.

**get(K key)**

Get algoritmi saa parametrinä avaimen, jolle vastaavaa arvoa haetaan puusta ja se palautetaan, jos löydetään. Arvoa haetaan kutsumalla juurisolmulta Treenoden rekursiivinen algoritmi getValue. Tässä rekursiiviisessa algoritmissä verrataan haettavaa avainta nykyiseen avaimeen ja jos se ei ole sama, tarkistetaan kummasta alipuusta sen pitäisi löytyä ja kutsutaan rekursiivisesti algoritmiä sille alipuulle.

Aikakompleksisuus:
Paras tapaus:
Mikäli puu on tyhjä tai haettava avain löydetään heti juurisolmusta, aikakompleksisuus on O(1).

Tyypillinen tapaus:
Puuta käydessä läpi haettavien alkioiden määrä puolittuu joka kerroksella, joten aikakompleksisuus on O(log n).

Huonoimmassa tapauksessa, mikäli puu on todella epätasapainoinen ja muistuttaa linkitettyä listaa, on aikakompleksisuus O(n).


**Haku BST vs SimpleContainer**

BST haku toteutetaan get algoritmin avulla ja SimpleContainerissa binäärihaun avulla. Teoriassa kummankin pitäisi olla aikakompleksisuudeltaan O(log n). 

![kuva](BST-search.png)
![kuva](SC-search.png)

Kuvista kuitenkin huomataan, että SimpleContainerin binary search on selkeästi nopeampi, kuin BST get algoritmi, vaikka aikakompleksisuus pitäisi olla sama. Suurilla aineistoilla suoritusaikojen kasvu myös näyttää hieman pienevän alemmassa binarySearch kuvaajassa. BST get käyttävää hakuoperaatiota kuvaava ylempi kuvaaja myös näyttäisi olevan enemmän lineaarinen. Tämä hitaus ja lineaarisuus voisi selittyä sillä, että puu on epätasapainossa, jolloin get algoritmin aikakompleksisuus kääntyy lineaariseksi O(n). Todennäköisesti testin puu on siis jonkinverran epätasapainossa, joka hidastaa get algoritmiä.

**find(Predicate<V> searcher)**

Find algoritmi tarkistaa, onko root solmu null, eli onko puussa elementtejä. Mikäli puu ei ole tyhjä, kutsutaan TreeNode luokan find algortimiä. Tämä TreeNode luokan algoritmi käy puuta läpi rekursiivisesti in-order järjestyksessä ja kokeilee elementtejä predikaatin ehdolla. Algoritmi palauttaa ensimmäisen alkion, joka täyttää predikaatin ehdon. Mikäli puu on tyhjä tai ehdon täyttävää alkiota ei löydetä, palautetaan kutsujalle null.

Aikakompleksisuus:
Paras tapaus, puu on tyhjä ja palautetaan suoraan null O(1).

Normaali tapaus: Käydään solmuja läpi niin kauan in order järjestyksessä, että predikaatin täyttävä ehto löytyy. Tämä on O(n), koska kaikki alkiot käydään järjestyksessä läpi, eli suoritusaika riippuu puun koosta.

Huonoin tapaus, puusta ei löydy haettavaa arvoa ja palautetaan null. Aikakompleksisuus O(n) ja jokainen solmu käydään läpi järjestyksessä.

**size, capacity, clear**

Nämä kaikki ovat vakioaikaisia metodeja O(1), size metodi palauttaa puhun lisättyjen solmujen laskurin arvon, ja capacity tässä tapauksessa palauttaa Integer.max, sillä binäärisellä hakupuulla on teoriassa rajaton kapasiteetti. Käytännössä tietokoneen välimuisti loppuu kesken jossain vaiheessa, jos puuhun lisätään karmea määrä solmuja. Clear metodi alustaa puun juuren tyhjäksi ja nollaa laskurimuuttujan.

**toArray()**

toArray algoritmi käy rekursiivisesti puun läpi in order läpikäynnillä. Jos puu on tyhjä, niin palautetaan tyhjä Pair taulukko, muuten pair oliot siirretään puusta uuteen taulukkoon avaimen mukaan in order järjestyksessä. 

Aikakompleksisuus:
Paras tapaus, puu on tyhjä ja palautetaan suoraan tyhjä taulukko O(1).

Normaali tapaus, puu käydään in order järjestyksessä läpi, ja jokainen solmu lisätään avaimen mukaiseen in order järjestykseen taulukkoon. Tässä käydään järjestyksessä läpi koko puu, eli aikakompleksisuus on O(n).

**To sorted array BST vs SimpleContainer**
SimpleContainerissa lajiteltuun taulukkoon saaminen vaatii lajittelua, joka tehdään quickSort algoritmiä hyödyntämällä. BST versiossa riittää toArray kutsu, sillä toArray käy puun läpi järjestyksessä siirtäessään elementtejä taulukkoon. QuickSortin keskimääräinen aikakompleksisuus on O(n log n) ja BST toArrayn O(n), joten teoriassa BST tulisi olla nopeampi.

![kuva](BST-toArray.png)
![kuva](SC-toarray.png)

Kuvaajistahan ilmenee, että BST toarray todellakin on nopeampi tapa saada lajiteltu taulukko, kuin SimpleContainerin sort metodia (quickSort) käyttämällä. Esimerkiksi 100000 aineiston kohdalla BST toArray vie aikaa 6ms, kun taas vertailtava ratkaisu vie 76ms.


**indexOf(K itemKey)**

Tässä algoritmissä parametrina annetulla avaimelle haetaan indeksin arvoa. Algortimissä käydään iteratiivisesti pino tietorakennetta hyödyntäen solmuja läpi in order järjestyksessä pitäen kirjaa solmujen indeksistä. Jokaisen solmun kohdalla ensimmäisestä alkaen tarkistetaan, että vastaako solmun avain parametrina saatua avainta. Mikäli avaimet vastaa toisiaan, niin solmua vastaava indeksi palautetaan kutsujalle.

Tässäkin solmuja käydään järjestyksessä läpi siihen asti, että haettava solmu löytyy, joten suoritusaika riippuu solmujen määrästä, eli puun koosta O(n).


**getIndex(int index)**

Tämä algoritmi muistuttaa toiminnaltaan paljon yleempänä olevaa indexOf algoritmiä, mutta tässä palautetaan indeksin sijaan parametrina saadussa indeksissä oleva avain-arvo pari. Algoritmmissä käydään iteratiivisesti in order läpikäynnillä solmuja, ja palautetaan arvopari, joka on haetussa indeksissä. Mikäli indeksiä ei löydy, palautetaan null.

Aikakompleksisuus: Algoritmin aikakompleksisuus on O(n), sillä solmuja käydään läpi järjestyksessä yksi kerrallaan ja suoritusaika riippuu solmujen määrästä.

**getIndex BST vs SimpleContainer**

![kuva](BST-getIndex.png)
![kuva](SC-getindex.png)

BST toteutus getIndex algoritmistä todettiin olevan lineaarinen O(n), mutta SimpleContaineria tarkastelemalla huomataan, että sama algoritmi on teoriassa vakioaikainen O(1), sillä taulukosta saadaan palautettua suoraan arvo kyseisestä indeksistä viittaamalla siihen lauseella array[index]. Sama huomataan kuvaajista, sillä BST kuvaajassa nähdään lineaarinen käyrä ja SimpleContainerissa suoritusajat ovat hyvin nopeita (0-1ms), yhtä aikapiikkiä lukuunottamatta. Algoritmin suorituksessa on 50000 alkion aineiston kohdalla aikapiikki 6ms, joka todennäköisesti johtuu jostain muusta syystä, tietokoneen muista samanaikaisista prosesseista, sillä tämän algoritmin pitäisi olla vakioaikainen.

Teoriassa simpleContainerin tulisi olla selvästi nopeampi tässä operaatiossa ja näinhän se on kuvaajienkin perusteella. Esimerkiksi 100000 alkion tapauksessa SimpleContainerin suoritusaika oli pyöristynyt 0ms, kun taas BST sama operaatio vaati 153095ms, eli noin 2,5 minuuttia.

**findIndex(Predicate<V> searcher)**

Tässäkin algoritmissä käydään iteratiivisesti puuta läpi in order läpikäynnillä. Algoritmi testaa järjestyksessä täyttääkö solmussa oleva arvo predikaatin ehdon. Mikäli se täyttää, palautetaan sen indeksi ja jos ei, niin siirrytään järjestyksessä seuraavaan solmuun. Jos mikään solmu ei täytä ehtoa, niin palautetaan indeksinä -1.

Aikakompleksisuus: Algoritmin aikakompleksisuus on lineaarinen O(n), sillä solmuja käydään läpi järjestyksessä yksi kerrallaan ja suoritusaika riippuu solmujen määrästä.


**Puun teoreettinen syvyys ja toteutuksen todellinen maksimisyvyys**

| n	| O(log n)	| toteutunut max	|
|-----|--------|--------|
| 100	 | 6	| 12	|
| 1000 |	9	| 21	| 
| 5000 | 12		| 28	|
| 10000 | 13	| 29	|
| 50000 | 15	| 39	|
| 100000 | 19	| 37	|


Taulukossa O(log n) sarakkeessa nähdään täysin tasapainoisen puun teoreettinen syvyys ja toteutunut max kohdassa puun todellinen maksimisyvyys.

Taulukosta nähdään, että toteutunut maximi on teoreettista selvästi suurempi, joten puu ei ole tasapainoinen. Kuitenkaan suurilla aineistoilla puun maksimisyvyys ei kasva lineaarisesti, eli puu ei degeneroidu täysin linkitetyksi listaksi.

**Kokemukset Tira Coder käyttöliittymässä**

Ottaessani BST käyttöön Coder sovelluksessa huomasin käyttöliittymän muuttuvan hieman takertelevaksi varsinkin isoilla aineistoilla. Mielestäni käyttökokemus oli miellyttävällä tasolla, kunnes latasin miljoonan koodarin aineiston. Tällä aineistolla sort order:in vaihtaminen kesti todella kauan ja kavereiden hakeminen kesti jopa 399ms. Myös listan selaaminen.

100 000 aineiston kanssa listaa pystyi selaamaan, mutta pientä takertelua oli havaittavissa, ei kuitenkaan mitään verrattuna miljoonan koodarin aineistoon. Tällä aineistolla aikaa vievin toimenpide oli järjestyksen vaihtaminen koodarinimeksi. Vaihto vei 1535ms, jonka odottamisen kyllä huomaa. Muuten hakemiset ja koodarin tietojen saamiset eivät vieneet yli 200ms.



## 08-TASK

Tässä tehtävässä opin tietojen hashaamisen, eli hajautusalgoritmin käytön, sekä törmäysten käsittelyä  sekä hallintaa lineaarisella luotaamisella. Myös tehtävässä tehty täyttöasteen valvonta oli uutta, sillä aiemmin olen allokoinut taulukoihin lisää tilaa, vasta kun taulukko on täynnä. Ymmärsin, että hajautustaulussa tämä on tärkeää, jotta vältyttäisiin suurilta törmäysmääriltä.


**Hajautusalgoritmi**

Aloitin tehtävän tekemisen toteuttamalla hajautusfunktion. Aloitin toteuttamisen seuraamalla liveluennolla, sekä UUIDHashTestApp lähdekoodissa esiteltyä hajautusfunktiota. Tämä algoritmi perustuu siihen, että avaimen joka kirjaimen ascii-arvot lisätään yhteen.Kuitenkin testit ajaessa totesin, että tämän hajautusfunktion toimintakyky ei ole lähellekkään riittävän hyvä. Esimerkiksi testin suurimmalla 2000000 koodarin aineistolla duplikaatteja arvoja tuli yhteensä 1998951 kappaletta.

Muokkasin tätä hajautusfunktiota enemmän luentomateriaalin pseudokoodissa esitellyn hajautusfunktion kaltaiseksi, ja suorituskyky parani heti heittämällä. Tässä versiossa valitaan hash-arvoksi alkuluku 31 ja käydään id merkkijono läpi kirjain kerrallaan. Jokaisen kirjaimen kohdalla kerrotaan edellinen hash arvo 31:llä ja lisätään siihen nykyisen merkin ascii arvo.

Uudella hajautusfunktiolla ensimmäiset duplikaatit arvot syntyivät vasta 7. testissä, ja suurimmankin aineiston testissä duplikaatteja oli vain 496 kpl, eli selkeästi vähemmän verrattuna ensimmäiseen toteutukseen.

Vertasin hajautusfunktioita myös UUIDHashTestApp työkalulla:

Versio 1 Coder.hashFromLive()
![kuva](badHash.png)


Versio 2 Coder.hash()
![kuva](betterHash.png)

Kuten kuvista näkee, versio 2 on selvästi nopeampi ja törmäyksiä tulee kokonaisuudessaan noin 40 000, kun taas version 1 kohdalla törmäyksiä on n. 1,2 miljardia.

Kummankin algoritmin aikakompleksisuus on O(n), jossa n on hajautettavan merkkijonon pituus (tässä tapauksessa id). Tämä johtuu siitä, että algoritmissä iteroidaan merkkijonon läpi kirjain kerrallaan. Kuitenkaan tämä ei vaikuta HashTablen suorituskykyyn, sillä hajautusalgoritmin suoritusaika ei ole riippuvainen hajautustaulun kooosta.

Nykyinen hajautusalgoritmi on selvästi parempi, mutta edelleen voisi olla parantamisen varaa. 100 alkion testissä törmäyksiä sattui hajautustauluun lisätessä 4 avaimella ja pisin törmäysketju oli 10. Suurempi ongelma on tuo törmäysketju, joka voitaisiin hoitaa paremmalla törmäystenkäsittelymenetelmällä.

**Algoritmien analysointi ja oikeellisuus**

**add(K key, V value)**

Add algoritmi lisää hajautustauluun uuden avain-arvo parin, jos kumpikaan arvoista ei ole null. Null arvon sattuessa algoritmi heittää poikkeuksen. Mikäli lisätessä syntyy törmäyksiä, ne käsitellään lineaarisella luotaamisella. Algoritmi kutsuu myös tarvittaessa reallocate apumetodia, mikäli taulukon täyttöaste ylittää yli 60%. Allokoinnissa tiedot lisätään uudelleen uuteen taulukkoon, mikä varmistaa sen, että tiedot pysyvät oikeissa indekseissä.

Aikatehokkuus:
Parhaassa tapauksessa algoritmin aikatehokkuus on vakio, eli O(1). Tämä tilanne toteutuu silloin, kun törmäyksiä ei tule ja pari lisätään suoraan laskettuun indeksiin. Keskimääräinen tapaus on myös lähellä tätä, kun hajautusalgoritmi toimii hyvin.

Huonoin tapaus: Mikäli useampi avain tai jopa kaikki avaimet tuottaa saman hashkoodin, kipuaa aikakompleksisuus neliölliseksi O(n), sillä silloin joudutaan käymään lineaarisella luotaamisella taulukon kaikki alkiot läpi.

Aikatehokkuus nousee lineaariseksi myös silloin, kun täyttöaste ylittää 60%. Tämä johtuu siitä, että silloin allokoidaan taulukko kaksinkertaiseksi ja reallocate apualgoritmi on aikakompleksisuudeltaan O(n).

**Hashtable vs simpleKeyedTable**

Add metodi vertailutietorakenteessa on toteutettu siten, että uusi elementti lisätään aina suoraan taulukon loppuun, jolloin aikakompleksisuus on teoriassa O(1), jos ei jouduta reallokoimaan. Mikäli reallokointi tulee tehdä, aikakompleksisuus on O(n).

![kuva](HT-add.png)
![kuva](SKC-add.png)

Kuvista huomataan, että vertailtava simpleKeyedContainer todellakin on nopeampi, vaikka teoriassa parhaassa tapauksessa aikakompleksisuus pitäisi olla sama. Molempien käyrät näyttävät lineaariselta, koska laajojen aineistojen testeillä joudutaan reallokoimaan usein. Tämän vuoksi todelliset aikakompleksisuudet näyttävät olevan lineaarisia O(n). 
HashTablen hitauden selittää myös se, että lisätessä hajautustauluun tulee törmäyksiä, ja lineaarinen luotaaminen vie suorituskyvyltä tilaa. Lisäksi reallokointia tulee tehdä vielä useammin, sillä se suoritetaan täyttöasteen saavuttaessa 60%.


**get(K key)**

Get algoritmi hakee hajautustaulusta arvon parametrinä saadun avaimen perusteella. Mikäli annettu avain on null, algoritmi heittää poikkeuksen. Saadulle avaimelle lasketaan hashkoodin avulla indeksi ja tällä indeksillä etsitään vastaavaa paria hajautustaulusta. Mikäli oikeaa paria ei löydy tästä indeksistä on syntynyt törmäys, ja se käsitellään lineaarisen luotaamisen avulla. Mikäli avainta ei löydy ollenkaan, algoritmi palauttaa null. Oikean parin löytyessä palauteutaan avain-arvo parin arvo.

Aikakompleksisuus:
Parhaassa tapauksessa ei ole syntynyt törmäyksiä ollenkaan, jolloin haettava avain on heti lasketussa indeksissä. Tällöin aikakompleksisuus on vakio O(1). Hyvin toimiva hajautusfunktio mahdollistaa keskimääräisen aikakompleksisuuden olevan myös O(1).

Huonoimmassa tapauksessa, mikäli törmäyksiä on syntynyt paljon, joudutaan lineaarisella luotaamisella käymään useampi alkio läpi, jolloin aikakompleksisuus voi pahimmillaan olla lineaarinen O(n).

**Hashtable vs simpleKeyedTable**
Vertailtavan tietorakenteen get algoritmina aikakompleksisuus on lineaarinen O(n), sillä siinä käydään taulukkoa läpi niin kauan, että etsittävä arvo löytyy. Sen siis pitäisi teoriassa olla hitaampi, kuin hajautustaulun.

![kuva](HT-search.png)
![kuva](SKC-search.png)

Kuten kuvaajista näkee, hajautustaulun haku, eli get algoritmi on todella paljon nopeampi, kuin vertailtava simpleKeyedTable.

**find(Predicate<V> searcher)**

Find algoritmissä käydään hajautustaulun taulukkoa läpi yksinkertaisella silmukalla, jossa jokaisen ei tyhjän alkion kohdalla testataan, täyttääkö indeksissä oleva arvo predikaatin ehdon. Mikäli kyllä, tämä arvo palautetaan kutsujalle. Jos arvoa ei löydetä, palautetaan null.

Aikakompleksisuus tässä algoritmissä on lineaarinen O(n), sillä taulukon jokainen alkio joudutaan käymään läpi, eli suoritusaika on riippuvainen taulukon koosta.

**toArray()**

Tämä algoritmi käy läpi taulukon ja kopioi kaikki, paitsi null arvot uuteen taulukkoon. Taulukkoon ei päädy null alkioita, toisin kuin hajautustaulun sisäisenä tietorakenteena toimivassa taulukossa on.

Algoritmin aikakompleksisuus on lineaarinen O(n), sillä sen suoritusaika on riippuvainen taulukossa olevien elementtien määrästä.

**Hashtable vs simpleKeyedTable**
Kummassakin toteutuksessa toArray algoritmi on hyvin samankaltainen toiminnallisuudeltaan. Testeissä on myös käytetty samaa lajittelualgoritmiä kummallekkin tietorakenteelle.

![kuva](HT-toArray.png)
![kuva](SKC-toArray.png.)

Kuvaajista huomataan, että samankaltaisesta toteutuksesta huolimatta simpleKeyedTable näyttäisi olevan jopa noin puolet nopeampi hajautustauluun verrattuna. Tämä johtuu siitä, että simpleKeyedTablen toArray algoritmi pyörii vain juuri niin pitkälle kuin on tarvetta. Tämä on mahdollista, sillä elementit ovat taulukossa järjestyksessä, joten lopussa olevia mahdollisia tyhjiä paikkoja ei tarvitse iteroida läpi.

Hajautustaulussa tyhjät paikat taas ovat sekaisin pitkin taulukkoa, joten koko taulukko pitää iteroida läpi. Suuri hidastava tekijä tässä on se, että hajautustaulun taulukossa on vähintään 40% tyhjiä paikkoja, jotta törmäyksiä voitaisiin minimoida.

**Privaatit apumetodit**

**indexfor(int hash, int collisionCount)**
Tämä algoritmi laskee taulukon indeksin annetulle hashkoodille ja törmäysmäärälle. Indeksin laskemisessa varmistetaan, ettei indeksi voi olla negatiivinen. 

Tässä metodissa suoritetaan vain indeksin laskenta ja se on vakioaikainen O(1)

**reallocate(int newCapacity)**
Tämä apualgoritmi luo uuden taulukon, jonka kapasiteetti on annettu newCapacity. Uuteen taulukkoon lisätään arvot vanhasta taulukosta käyttämällä add(K key) algoritmiä, jotta ne sijoittuvat taulukossa oikeisiin indekseihin.

Tässä käydään läpi kaikki vanhan taulun elementit, joten aikakompleksisuus on lineaarinen O(n), missä n on vanhan taulukon koko.


**hashTable vs BST**

Teoriassa hashtablen pitäisi olla binääristä hakupuuta nopeampi, sillä hajautustaulussa algoritmien keskimääräinen aikakompleksisuus on O(1), kun binäärisessä hakupuussa O(log n)

![kuva](BSTvsHashGet1.png)
![kuva](BSTvsHashAdd1.png)

Kuvaajista huomataan, että hajautustauluhan näyttäisi olevan nopeampi, kuin BST get ja add operaatioissa. Add operaatiossa tapahtuu hieman vaihteluja, jolloin puolestaan BST on selvästi nopeampi. Tämä voi selittyä epätasaiseksi muodostuneella taulukolla, jolloin lineaarista luotaamista on jouduttu tekemään paljon.




![kuva](BST-toArray.png)
![kuva](HT-toArray.png)

Tietojen saaminen järjestettyyn taulukkoon onkin BST:ssä reilusti nopeampaa. Tämä selittyy sillä, että BST:n toArray lisää elementit taulukkoon valmiiksi järjestyksessä O(n) operaatiolla, jossa n on elementtien määrä. Hajautustaulun tapauksessa ensin lisätään elementit uuteen taulukkoon O(n) operaatiolla, jossa n on taulukon kapasiteetti, eli joudutaan iteroimaan paljon tyhjiä paikkoja. Tämän jälkeen uusi taulukko on täytetty, mutta ei järjestyksessä, joten kutsutaan QuickSortia, jonka aikakompleksisuus on O(n log n).

**milloin hajautustaulu vai BST**

Hajautustaulu erottuu edukseen erityisesti suurilla aineistoilla lisättäessä tai haettaessa elementtejä. Nämä operaatiot ovat nopeampia, kuin BST:ssä vastaavilla aineistoilla.

Kuitenkin mikäli halutaan järjesteltyä tietoa, kannattaa valita BST, sillä puu varastoi tiedot järjestyksessä, kun taas hajautustaulussa tiedot ovat missä sattuu ja taulukossa on paljon tyhjiä paikkoja. Tietojen saaminen järjestettyyn taulukkoon onkin BST tietorakenteessa todella paljon nopeampaa, kuten kuvaajasta nähdään.


## 09-TASK