A feladat �sszefoglal� le�r�sa
Ebben a feladatban egy bankrendszer leegyszer�s�tett m�k�d�s�t fogjuk szimul�lni. A szimul�ci�ban szerepelnek bankok �s szem�lyek �s egy bankjegykiad� automata, amib�l az emberek p�nzt tudnak felvenni, vagy p�nzt tudnak betenni oda.

A r�szfeladatok megold�sa sor�n �gyelj�nk arra, hogy a megadottakon k�v�l egyetlen oszt�ly se tartalmazzon m�s publikus met�dust vagy adattagot, illetve egyik csomag se tartalmazzon m�s oszt�lyokat! Ha az implement�ci� megk�veteli, akkor az oszt�lyok rejtett adattagokkal �s met�dusokkal szabadon b�v�thet�k. A megold�st egyetlen .zip �llom�nyk�nt kell felt�lteni, amely tartalmazza a csomagnak megfelel� k�nyvt�rszerkezetben az �sszes forr�sk�dot. A ford�t�s sor�n keletkez� .class �llom�nyokat viszont m�r nem szabad mell�kelni! A ford�t�shoz legal�bb a Java Standard Edition 8 haszn�lata k�telez�.

A feladathoz tartozik egy let�lthet� seg�dlet, ahol tal�lunk egy minta bemeneti f�jlt �s egy ahhoz tartoz� kimeneti f�jlt, tov�bb� egy�b seg�ts�get a tesztel�shez.

A feladat megold�sa sor�n be kell tartani a k�dol�si konvenci�kat.
A k�dol�si konvenci�k k�z�l k�l�n kiemelend�, hogy ha valamilyen feladat vagy ellen�rz�s elv�gz�s�re valamelyik oszt�ly m�r tartalmaz megfelel� met�dust, akkor azt kell haszn�lni, nem pedig �jra leprogramozni (vagy �tm�solni) az adott r�szt. (Bizonyos helyeken ezt a feladat k�l�n ki is emeli, de erre k�l�n figyelmeztet�s n�lk�l is �gyelni kell.)

A feladat r�szletes ismertet�se
financial.bank.Bank
Hozzuk l�tre a financial.bank csomagban a Bank oszt�lyt, ami egy felsorol�si t�pus, az egyes bankok r�vid�tett neveit tartalmazza.

Az oszt�ly lehets�ges �rt�kei legyenek a k�vetkez�k: BB, OTP, Erste, CIB, Raiffeisen, Citibank, FHB, MKB �s UniCredit.

financial.person.Customer
Hozzuk l�tre a financial.person csomagban a Customer oszt�lyt, ami egy foly�sz�ml�val rendelkez� szem�lyt val�s�t meg. A feladatban egy embernek pontosan egy bankn�l van foly�sz�ml�ja.

Az oszt�lynak legyen n�gy rejtett adattagja:

name: sz�veges t�pus�, a szem�ly nev�t t�rolja

birthYear: eg�sz sz�m, a szem�ly sz�let�si �ve

bank: Bank t�pus�, azt t�rolja, hogy melyik bankn�l van a szem�ly (egyetlen) foly�sz�ml�ja

amount: eg�sz sz�m, a szem�ly aktu�lis egyenlege a foly�sz�ml�j�n

K�sz�ts�k el a k�vetkez� met�dusokat:

Az oszt�lynak legyen egy rejtett konstruktora: Customer(String name, int birthYear, Bank bank), amely ellen�rz�s n�lk�l be�ll�tja az adattagokat a megadott �rt�kekre, a kezdeti egyenleg legyen 0.

Legyen egy publikus oszt�lyszint� Customer visszat�r�si �rt�k� met�dus: makeCustomer(String name, int birthYear, String bankName), ami ellen�rzi a param�tereket, �s ha azok megfelel�ek, akkor l�trehozza a param�tereknek megfelel� Customer objektumot �s visszaadja. Ha a param�terek nem megfelel�ek, akkor a met�dus adjon vissza null referenci�t. A met�dusnak ellen�rz�skor a k�vetkez�ket kell megvizsg�lnia:

A n�v csak az angol abc bet�ib�l �s sz�k�zb�l �llhat. A n�v egyes r�szeit (vezet�knevek, keresztnevek) pontosan egy sz�k�z v�lasztja el egym�st�l. A n�v legal�bb 2, legfeljebb 4 r�szb�l �ll, melyben minden r�sz legal�bb h�rom karakter hossz�, nagybet�vel kezd�dik, ut�na viszont csak kisbet�b�l �llhat.
(seg�ts�g: haszn�lhatod a String oszt�ly split �s charAt met�dus�t, illetve a Character oszt�ly isUpperCase �s isLowerCase met�dus�t)

A sz�let�si �vnek 1918 �s 1998 k�z�ttinek kell lennie (az 1918 �s az 1998 �rt�ket is felveheti).

A bankName-nek a Bank t�pus egyik lehets�ges �rt�k�vel kell egyeznie.
(seg�ts�g: sz�veges t�pusb�l egy adott felsorol�si t�pusba tartoz� objektumm� konvert�l�shoz haszn�lhatod az adott felsorol�si t�pus ("automatikusan" l�tez�) oszt�lyszint� valueOf met�dus�t, amely IllegalArgumentException kiv�telt dob, ha a sz�veg nem egyezik meg a felsorol�si t�pus egyetlen lehets�ges �rt�k�vel sem)

Az oszt�ly tartalmazza a k�vetkez� publikus "getter" met�dusokat: getName, getBank, getAmount, amelyek visszaadj�k az adott �rt�keket

Legyen egy publikus void visszat�r�si �rt�k�, eg�sz param�ter� decreaseAmount met�dus, amely az adott �rt�kkel cs�kkenti az egyenleget. Semmif�le ellen�rz�st nem kell v�gezni.

Legyen egy publikus void visszat�r�si �rt�k�, eg�sz param�ter� increaseAmount met�dus, amely az adott �rt�kkel n�veli az egyenleget.

Legyen egy publikus sz�veges visszat�r�si �rt�k�, param�ter n�lk�li toString met�dus, ami a k�vetkez� form�ban adja vissza a szem�ly sz�veges reprezent�ci�j�t: N�v: egyenleg

financial.bank.ATM
Hozzuk l�tre a financial.bank csomagban az ATM oszt�lyt, ami egy p�nzkiad� automat�t val�s�t meg.

Az oszt�lynak legyen k�t rejtett adattagja:

bank: Bank t�pus� �rt�k, azt t�rolja, hogy melyik bankhoz tartozik az automata (az automat�b�l m�s bank �gyfelei is kivehetnek p�nzt, csak �k magasabb k�lts�ggel)

amount: eg�sz t�pus� �rt�k, azt t�rolja, hogy aktu�lisan mennyi p�nz van az automat�ban

K�sz�ts�k el a k�vetkez� met�dusokat:

Az oszt�lynak legyen egy rejtett konstruktora: ATM(Bank bank, int amount), amely a megadott adatokkal - ellen�rz�s n�lk�l - l�trehozza az objektumot.

Legyen egy publikus oszt�lyszint�, ATM visszat�r�si �rt�k� met�dus: makeATM(String bankName, int amount), ami ellen�rzi a param�tereket, �s amennyiben azok megfelel�ek, akkor l�trehozza �s visszaadja az ATM objektumot. Ha a param�terek nem megfelel�ek, akkor a met�dus adjon vissza null referenci�t. Az ellen�rz�skor a k�vetkez�ket kell megvizsg�lni:

A bankName-nek a Bank t�pus egyik lehets�ges �rt�k�vel kell egyeznie.

Az egyenlegnek pozit�vnak kell lennie.

Legyen egy publikus eg�sz visszat�r�si �rt�k�, param�ter n�lk�li getAmount met�dus, amely visszaadja az automat�ban l�v� p�nz mennyis�g�t.

Legyen egy publikus void visszat�r�si �rt�k�, eg�sz param�ter� decreaseAmount met�dus, amely az adott �rt�kkel cs�kkenti az egyenleget (semmif�le ellen�rz�st nem kell v�gezni).

Legyen egy publikus void visszat�r�si �rt�k�, eg�sz param�ter� increaseAmount met�dus, az adott �rt�kkel n�veli az egyenleget.

Legyen egy publikus eg�sz visszat�r�si �rt�k� calculateFee(Bank bank, int value) met�dus, amely kisz�molja a p�nzfelv�teli d�jat annak f�ggv�ny�ben, hogy a felvev� foly�sz�ml�ja melyik bankn�l van (bank param�ter) �s mekkora �sszeget szeretne felvenni (value param�ter). A d�jat a k�vetkez�k�ppen kell sz�molni:

ha az automata a p�nzfelvev� saj�t bankj�nak automat�ja, akkor a d�j az �sszeg 1%-a (felfel� kerek�tve), de legal�bb 200 Ft.

idegen bank eset�n a d�j az �sszeg 3%-a (felfel� kerek�tve), de legal�bb 500 Ft.

(seg�ts�g: kerek�t�shez haszn�lhatod a Math oszt�ly ceil met�dus�t)

financial.Simulator
Hozzuk l�tre a financial csomagban az Simulator oszt�lyt, ami a bankvil�g szimul�ci�j�t v�gzi.

Az oszt�lynak legyen h�rom rejtett adattagja:

atm: ATM t�pus� (a szimul�ci�ban egyetlen automata szerepel)

customers: olyan adatszerkezet, amiben Customer t�pus� objektumokat lehet t�rolni (ez lehet p�ld�ul t�mb, ArrayList vagy LinkedList; t�mb eset�n felhaszn�lhatjuk, hogy maximum 50 felhaszn�l� lehet a szimul�ci�ban)

pwLog: PrintWriter t�pus� objektum, amelyet logf�jl vezet�s�hez haszn�lunk

K�sz�ts�k el a k�vetkez� met�dusokat:

Az oszt�lynak legyen egy publikus konstruktora: Simulator(String bankName, int initAmount, String outputFileName)

Ha a param�terek megfelel�ek (l�sd a makeATM met�dusn�l �rtakat), akkor a konstruktor a hozza l�tre a megadott bankhoz tartoz� automat�t a megadott kezdeti �sszeggel. Ha az adatok nem megfelel�ek, akkor a met�dus dobjon IllegalArgumentException kiv�telt.
(seg�ts�g: egy ATM objektum param�tereinek ellen�rz�s�re �s helyes param�terek eset�n l�trehoz�s�ra m�r van megfelel� met�dus az ATM oszt�lyban, �gy k�d-duplik�ci� helyett azt kell megh�vni)

A Customer objektumokat tartalmaz� adatszerkezet kezdetben ne tartalmazzon egyetlen objektumot sem.

A PrintWriter objektumot hozzuk l�tre a megadott f�jln�vhez (ha a f�jl nem hozhat� l�tre, vagy nem nyithat� meg �r�shoz, akkor a met�dus engedje ki a keletkez� kiv�telt).

Legyen egy rejtett Customer visszat�r�si �rt�k� sz�veges param�ter� getCustomerByName met�dus, amely visszaadja a customers adatszerkezetb�l annak a Customer objektumnak a referenci�j�t, amelynek a neve megegyezik a param�terben megadott sz�veggel. Felt�telezhetj�k, hogy egy n�v csak egyszer szerepel (ezt az insertCustomer met�dus fogja biztos�tani). Ha az adatszerkezetben nincs megfelel� objektum, akkor a met�dus adjon vissza null referenci�t.
Az objektumot nem kell lem�solni, csak a referenci�j�t kell visszaadni.

Legyen egy publikus void visszat�r�si �rt�k� insertCustomer(String customerName, int birthYear, String bankName) met�dus, amellyel egy Customer objektumot lehet felvinni a nyilv�ntart�sba. A szem�ly akkor vehet� fel, ha ilyen nev� m�g nem szerepel az adatszerkezetben, tov�bb� ha a szem�ly adatai megfelel�ek (l�sd a makeCustomer met�dusn�l �rtakat). Ha a szem�ly m�r szerepel a nyilv�ntart�sban, vagy valamelyik param�ter nem megfelel�, akkor a Customer objektumokat t�rol� adatszerkezet maradjon v�ltozatlan.
(seg�ts�g: haszn�ld a makeCustomer �s getCustomerByName met�dusokat)

Legyen egy publikus void visszat�r�si �rt�k� withdrawCash(String customerName, int amount) met�dus, amellyel k�szp�nzt lehet felvenni az automat�b�l.

Ha ilyen nev� szem�ly nem szerepel a nyilv�ntart�sban (haszn�ld a getCustomerByName met�dust), vagy ha az automat�ban nincs el�g k�szp�nz, vagy a felvenni k�v�nt �sszeg 0 vagy negat�v, akkor a met�dus nem csin�l semmit.

Ha ilyen nev� szem�ly szerepel a megfelel� adatszerkezetben �s az automat�ban is van el�g p�nz, akkor a met�dus kisz�m�tja a p�nzfelv�tel d�j�t, majd ellen�rzi, hogy az adott szem�ly foly�sz�ml�j�n van-e legal�bb akkora fedezet, mint amennyi a felvenni k�v�nt �sszeg �s a p�nzfelv�teli d�j egy�ttesen. Ha a szem�ly egyenlege nem el�g nagy, akkor a met�dus nem csin�l semmit.

Ha minden ellen�rz�s sikeres, akkor a met�dus az adott szem�ly foly�sz�ml�j�nak egyenleg�t az �sszeggel �s a k�szp�nzfelv�teli d�jjal cs�kkenti (mert a szem�lynek a felv�tel d�j�t is meg kell fizetnie), az automat�ban l�v� p�nz�sszeget viszont csak a felvenni k�v�nt �sszeggel cs�kkenti (mert az automata t�nylegesen csak annyit ad ki).

Ha t�rt�nt k�szp�nzfelv�tel, akkor a met�dus a logf�jlba �rja ki a felvev� sz�veges reprezent�ci�j�t. Ha nem t�rt�nt k�szp�nzfelv�tel, akkor semmit se �rjon a logf�jlba.

Legyen egy publikus void visszat�r�si �rt�k� depositCash(String customerName, int amount) met�dus, amellyel p�nzt lehet betenni az automat�ba. Ha ilyen nev� szem�ly nem szerepel a nyilv�ntart�sban, vagy az �sszeg 0 vagy negat�v, akkor a met�dus ne csin�ljon semmit. Ellenkez� esetben mind az automat�ban l�v� p�nz�sszeget, mind az adott szem�ly foly�sz�ml�j�n l�v� egyenleget n�velje meg az adott �rt�kkel (a p�nz bet�tel�nek nincs d�ja). Ha t�rt�nt k�szp�nz bet�t, akkor a met�dus a logf�jlba �rja ki a betev� szem�ly sz�veges reprezent�ci�j�t. Ellenkez� esetben semmit se �rjon a logf�jlba.

Legyen egy publikus void visszat�r�si �rt�k� simulate(String inputFileName) met�dus, amely a megadott nev� inputf�jl alapj�n szimul�ci�t hajt v�gre a bank-vil�gban.

A met�dus nyissa meg olvas�sra a megadott inputf�jlt (ha a f�jl nem l�tezik, vagy nem nyithat� meg olvas�shoz, akkor a met�dus engedje ki a keletkez� kiv�telt).

Ha siker�lt megnyitni a f�jlt, akkor a met�dus feladata, hogy azt feldolgozza.

Az inputf�jl minden sora egy m�veletet tartalmaz.

A m�velet k�t r�szb�l �ll, a r�szeket kett�spont v�lasztja el egym�st�l.

A m�velet els� r�sze 3 �rt�ket vehet fel:

REG: ebben az esetben a m�velet egy szem�ly felv�tele a nyilv�ntart�sba. Ekkor a m�velet m�sodik fele a szem�ly adatait tartalmazza vessz�vel elv�lasztva: n�v,sz�let�si�v,bankn�v sorrendben. Ha a szem�ly adatai megfelel�ek, �s m�g nem szerepel a nyilv�ntart�sban, akkor vegy�k fel.
(seg�ts�g: az ellen�rz�shez �s a felvitelhez haszn�ld az insertCustomer met�dust)

GET: ebben az esetben a m�velet a k�szp�nzfelv�tel. A m�velet m�sodik r�sze a felvev� nev�t �s a felvenni k�v�nt �sszeget tartalmazza vessz�vel elv�lasztva. Ha az adatok megfelel�ek, akkor t�rt�njen meg a k�szp�nz felv�tel.
(seg�ts�g: haszn�ld a withdrawCash met�dust)

PUT: ebben az esetben a m�velet a k�szp�nz bet�tele az automat�ba. Ekkor a m�velet m�sodik r�sze a betev� szem�ly nev�t �s a betenni k�v�nt �sszeget tartalmazza vessz�vel elv�lasztva. Ha az adatok megfelel�ek, akkor t�rt�njen meg a k�szp�nz bet�tel.
(seg�ts�g: haszn�ld a depositCash met�dust)

Ha b�rmelyik input-sor hib�s, teh�t nem a megfelel� tartalm� �s/vagy mennyis�g� adatot tartalmazza, akkor a sort figyelmen k�v�l kell hagyni, �s a feldolgoz�s folytat�djon a k�vetkez� sorral. Rossz lehet p�ld�ul az a sor, amelyik nem pontosan egy kett�spontot tartalmaz, vagy amin�l a kett�spont el�tt nem a h�rom megadott parancs egyike szerepel, vagy amelyik nem sz�mot tartalmaz ott, ahol sz�mot v�runk, vagy ahol nincs meg az �sszes sz�ks�ges adat (p�ld�ul a felv�teln�l hi�nyzik az �sszeg), stb.

Ha az inputf�jl feldolgoz�sa sor�n olvas�si hiba t�rt�nik, akkor a met�dus engedje ki a keletkez� kiv�telt.

Legyen egy publikus void visszat�r�si �rt�k�, param�ter n�lk�li close met�dus, amely lez�rja a logf�jlhoz l�trehozott PrintWriter objektumot.

main.Main
Az eddigi oszt�lyokb�l most m�r �ssze tudunk �ll�tani egy parancssorb�l is �n�ll�an futtathat� programot, amely a parancssori param�tereknek megfelel�en elk�sz�ti a szimul�ci� kezdeti vil�g�t, majd egy megadott inputf�jlnak megfelel�en v�grehajtja a szimul�ci�t. Az eredm�nyeket egy megadott outputf�jlba menti.

Hozzuk l�tre a main csomagban a Main oszt�lyt, amelyben legyen egy f�program! A k�vetkez�k�ppen kell viselkednie:

A f�program h�rom param�tert v�r: bankn�v inputf�jl outputf�jl

Ha nincs megfelel� sz�m� param�ter, akkor �rjon ki egy hiba�zenetet �s fejez�dj�n be.

Ha h�rom param�tert kapott, akkor a bankn�vvel, 1 000 000 Ft kezdeti egyenleggel �s az outputf�jl nev�vel hozza l�tre a Simulator objektumot. Ha l�trehoz�skor kiv�tel keletkezett, akkor a program egy megfelel� hiba�zenet ki�r�sa ut�n szab�lyosan fejez�d�n be.

Ha l�trej�tt a Simulator objektum, akkor h�vja meg annak simulate met�dus�t (�tadva neki az inputf�jlt). V�g�l h�vja meg az objektum close met�dus�t.
Ha a met�dusok v�grehajt�sa sor�n kiv�tel keletkezik, akkor a program egy megfelel� hiba�zenet ki�r�sa ut�n szab�lyosan fejez�d�n be.

Tesztel�s
A feladathoz tartoz� let�lthet� seg�dlet-ben tal�lhat� input.txt-t m�soljuk a megfelel� helyre. Ford�tsuk le a programot �s ind�tsuk el a k�vetkez� param�terez�ssel:
java main.Main BB input.txt output.txt

Ezut�n a keletkez� output.txt f�jlt vess�k �ssze a becsomagolt �llom�nyban l�v�vel, hogy l�ssuk, hogy a v�rt eredm�ny j�tt-e ki.

A t�m�r�tett �llom�nyban tal�lhat� magyarazat.txt nev� f�jl is, ami az input.txt sorait tartalmazza magyar�zatokkal kieg�sz�tve: minden sorn�l szerepel a program elv�rt viselked�se.

Figyelem: a helyes kimeneti f�jl m�g nem felt�tlen�l jelenti azt, hogy a megold�s helyes.

J� munk�t!