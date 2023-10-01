# UserMngmSisSQL

Pentru a folosi proiectul și a rula testele scrise cu JUnit, urmați acești pași:

Configurați Mediu de Dezvoltare (IDE):

Deschideți proiectul în mediul de dezvoltare Java (de obicei, folosind un IDE precum IntelliJ IDEA, Eclipse sau NetBeans).
Asigurați-vă că aveți JDK (Java Development Kit) instalat și configurat corect în mediul de dezvoltare.
Asigurați-vă că Dependințele sunt incărcate.

Configurați Baza de Date:

Dacă doriți să folosiți baza de date MySQL pentru a stoca datele utilizatorilor, asigurați-vă că aveți MySQL Server instalat și configurați un bază de date numită "userdb", cu o tabelă "users" cu câmpurile corespunzătoare (id, nume, prenume, email, varsta).
Modificați detaliile de conexiune la baza de date din clasa DBConnection pentru a se potrivi cu setările dvs. de bază de date.
Rulați Aplicația Principală:

Rulați clasa Main din proiect pentru a porni aplicația. Aceasta vă va afișa un meniu cu opțiuni pentru gestionarea utilizatorilor.
Rulați Testele JUnit:

Pentru a vă asigura că proiectul nu are erori, puteți rula testele JUnit. În IDE, căutați clasele de 
test JUnit, cum ar fi UserDatabaseImplTest, faceți clic dreapta pe acestea și alegeți opțiunea
 "Run" sau "Run Test".Testele ar trebui să ruleze și să furnizeze rezultatele, 
arătând dacă există erori în cod.
![image](https://github.com/AlinToda/UserMngmSisSQL/assets/134317996/91256f2a-2ba9-4dfa-beed-67b7ef33daf8)
