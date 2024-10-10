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

Puolitushaun käyttöehtona on se, että taulukko on valmiiksi lajiteltu. Tämä johtuu puolitushaun toimintaperiaatteesta, sillä se hyödyntää taulukon järjestystä vertaillessaan, onko haettava arvo suurempi vai pienempi, kuin taulukon keskikohta.

Edellisessä tehtävässä toteutettu lineaarinen haku toimii myös lajittelemattoman aineiston tapauksessa, sillä se käy haettavat arvot läpi yksitellen.

Tehokkuudensa ansiosta puolitushakua kannattaa käyttää lineaarisen haun sijaan, mikäli aineisto on lajiteltu. Esimerkkinä tästä tilanteesta on mainitsemani SimpleContainer.indexOf metodi, joka tarkistaa onko taulukkoa lajiteltu. Mikäli on, kutsutaan puolitushaku ja muussa tapauksessa käytetään lineaarista hakua.


## 04-TASK

Tässä tehtävässä toteutin pino rajapinnan StackInterface omaan toteutusluokkaani StackImplementation. Lisäksi hyödynsin toteutettua pinoa toteuttamalla sulkeidentarkistus algoritmin ohjeiden mukaisesti.

Tehtävässä vaikeinta oli poikkeuksien käsittely, sillä sen harjoittelu on ollut kohdallani liian vähäistä. Tätä tehtävää tehdessä sain hyvää kertausta poikkeusten heittämisen sekä käsittelyyn liittyen. Live luennon poikkeuksia koskevan kertauksen avulla sain paljon oppia aiheeseen liittyen.

Myös StringBuilderin käyttöön liittyen kertaaminen oli tervettulletta, sillä aiemmin olen toteuttanut toString() metodit String luokkaa hyödyntäen. Tehtävässä opin, että StringBuilderin käyttö on todella paljon tehokkaampaa aiemmin käyttämääni toteutukseen verrattuna.


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

Metodi kopioi pinon sisäisen taulukon elementit uuteen suurempaan taulukkoon ja korvaa pinon sisäisen taulukon uudella suuremmalla taulukolla.

Koska taulukon kaikki elementit tulee käydä kopioitaessa läpi, metodin aikakompleksisuus on O(n). Metodin suoritusaika riippuu taulukon elementtien määrästä.

Tämä metodi kutsutaan tarvittaessa push() metodista, joka aiheuttaa sen, että push metodin aikakompleksisuus on huonoimmassa tapauksessa myös O(n).

**toString()**
Aikakompleksisuus O(n)

toString metodin aikakompleksisuus on O(n), koska metodissa käydään läpi kaikki pinon sisäisen taulukon elementit, jotta niistä voidaan muodostaa merkkijono.
Suoritusaika määräytyy pinon taulukon elementtien määrästä, joten aikakompleksisuus on O(n).


## 05-TASK

## 06-TASK

## 07-TASK

## 08-TASK

## 09-TASK