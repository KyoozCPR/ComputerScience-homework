"""
Scrivere un programma che permetta di gestire i voti scolastici degli studenti, aggiungere voti per ogni materia e calcolarne la media dei voti.


E’ inoltre importante attenersi alle seguenti indicazioni:

Ogni studente ha un nome univoco.
Ogni studente ha dei voti associati a
più materie (ad esempio, Matematica, Storia, Italiano).
Ogni materia può avere più voti (ad esempio, Matematica: 10, 6, 5).




Mostrare un menù con le seguenti opzioni:


-Aggiungi voto: Permette di aggiungere un voto ad
uno studente su una materia esistente


-Visualizza voti: Il programma mostra le materie ed i
voti di uno studente


-Visualizza media: viene stampata la media dei voti di
uno studente


-Stampa report: mostra tutte le materie ed i voti
di tutti gli studenti


-Esci: il programma termina


-


Il file di testo su cui salvare le informazioni del programma è il
seguente: voti_scuola.txt


con le informazioni cosi salvate per ogni studente:


Nome_studente:Materia1=voto1,voto2,voto3|Materia2=voto1,voto2|Materia3=voto1
e così via.





I due punti : separano gli studenti, la barra verticale le materie | e
la virgola , i voti. Ogni studente occupa una riga del file


Es. Giulio: Matematica=2|8,Storia=5

      Federica:
Matematica=10|7|9,Storia=7|8
"""
import os

class Studente:
    MATERIE = ["Matematica", "Informatica", "Italiano", "Storia"]
    voti = [[],[],[],[]]

    def __init__(self, nominativo):
        self.nominativo = nominativo

    def __str__(self):
        stringaFinale = f"{str(self.nominativo)}: "
        for i in range(0,len(self.MATERIE)):
            stringaFinale += f"{str(self.MATERIE[i])}={str(self.voti[i])}"
        stringaFinale += ","
        return stringaFinale    

    def aggiungiVoto(self, materia:str, voto:int):
        indiceMateria = self.MATERIE.index(materia)
        self.voti[indiceMateria].append(voto)
        print("Voto aggiunto a ", self.MATERIE[indiceMateria])

    def mediaVoti(self):
        print("La media generale di ", self.nominativo, "è: ")
        somma = 0
        for i in range(0, len(self.voti)):
            for j in range(0, len(self.voti[i])):
                somma+=self.voti[i][j]

        media = somma / i   
        return media


classe = [Studente("Diego Ciprietti"), Studente("Marco Mainini"), Studente("Tommaso Malfasi"), Studente("Francesco Concu")]
    
    

def inputMenu():
    print("""
          0)Esci: il programma termina

          1)Aggiungi voto: Permette di aggiungere un voto ad uno studente su una materia esistente

          2)Visualizza voti: Il programma mostra le materie ed i voti di uno studente

          3)Visualizza media: viene stampata la media dei voti di uno studente
          
          4)Stampa report: mostra tutte le materie ed i voti di tutti gli studenti


    """)
    scelta = int(input("Inserisci il numero dell'operazione che vuole eseguire: "))
    return scelta


def ricercaStudente(nome: str):
    for studente in classe:
        if studente.nominativo == nome:
            return classe.index(studente)
        
    print("Studente non trovato!")
    return None    



def descrizioneStudenti():
    stringaFinale = ""
    for studente in classe:
            stringaFinale += studente.__str__()
    return stringaFinale        

 
def menu(scelta):
    if scelta == 0:
        print("Arrivederci!")
    elif scelta == 1:
        nomeStudente = str(input("Inserisci il nome dello studente a cui vuoi aggiungere un voto: "))
        posizioneStudente = ricercaStudente(nomeStudente)
        if (posizioneStudente != None):
            print(Studente.MATERIE)
            materiaScelta = -1
            while (materiaScelta < 0 or materiaScelta > 3):
                materiaScelta = int(input("\nScegli la materia in base all'indice [0-3]: "))
                try:
                    voto = int(input("Inserisci il voto da inserire: "))
                    classe[posizioneStudente].voti[materiaScelta].append(voto)
                except Exception:
                    print("Materia non valida! RIPROVARE!")
            print("Voto inserito!")        
                

    elif scelta == 2:
        nomeStudente = str(input("Inserisci il nome dello studente a cui vuoi aggiungere un voto: "))
        posizioneStudente = ricercaStudente(nomeStudente)
        if (posizioneStudente != None):
            print(classe[posizioneStudente])
    elif scelta == 3:
        nomeStudente = str(input("Inserisci il nome dello studente a cui vuoi aggiungere un voto: "))
        posizioneStudente = ricercaStudente(nomeStudente)
        if (posizioneStudente != None):
            media = classe[posizioneStudente].mediaVoti()
            if media != 0:
                print(str(media))
            else:
                print("Lo studente non presenta voti")    
    elif scelta == 4:
        print(descrizioneStudenti())
    else:
        print("Scelta non valida! riprovare")


def aggiornamentoFile():
    location = os.path.realpath(
    os.path.join(os.getcwd(), os.path.dirname(__file__)))
    with open(os.path.join(location, "voti_scuola.txt"), "w") as file:
        file.write(descrizioneStudenti())



if __name__ == "__main__":
    
    scelta = -1
    while (scelta != 0):
        scelta = inputMenu()
        menu(scelta)
        aggiornamentoFile()

    exit()


