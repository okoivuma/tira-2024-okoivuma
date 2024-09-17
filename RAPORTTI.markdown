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

## 03-TASK

## 04-TASK

## 05-TASK

## 06-TASK

## 07-TASK

## 08-TASK

## 09-TASK