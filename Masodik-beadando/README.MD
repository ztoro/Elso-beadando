Feladat:
Egy vállalat portaszolgálatán feljegyzik a belépő és kilépő személyek
adatait. Belépéskor rögzítik az aktuális időpontot, a belépő nevét és
azonosítására szolgáló igazolványszámot, távozáskor pedig a fenti három
adat mellé kerül a kilépés időpontja. A napi adatokat azonosító szerint,
azon belül belépési idő szerint növekvően rendezve egy szöveges
állományban tárolják. Feltehetjük, hogy az állomány minden sorában
három vagy négy olyan sztringet találunk, amelyeknek belsejében nincs
elválasztó jel, ugyanakkor tetszőleges számú elválasztó jel határolja
azokat.

Például az input fájl adatai:

10:30 Gipsz_Jakab 1234567A 10:15

10:45 Gipsz_Jakab 1234567A 11:30

08:35 Gyanús_Móric 1x1x1x1x1x

08:35 Gyanús_Móric 1x1x1x1x1x 08:10

08:35 Gyanús_Móric 1x1x1x1x1x

08:45 Szer_Elek 33332222 09:15

Ebben állományban akkor tekinthető egy sor korrektnek, ha egyrészt olyan
kilépési időpont szerepel benne, amely későbbi, mint a belépés időpontja 
(ezeket sztring összehasonlítással ellenőrizheti), másrészt, amennyiben a
szóban forgó személy másodjára vagy sokadjára lép be, akkor a megelőző
sorban rögzített kilépési idő nem későbbi, mint az újabb belépés belépési
ideje. Listázzuk ki az állomány inkorrekt sorait, valamint számoljuk meg a
hibás sorok számát! 
