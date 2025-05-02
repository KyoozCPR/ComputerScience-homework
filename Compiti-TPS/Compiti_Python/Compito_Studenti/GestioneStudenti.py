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


class Studente:
    MATERIE = ["Matematica", "Informatica", "Italiano", "Storia"]
    voti = [[],[],[],[]]

    def __init__(self, nominativo):
        self.nominativo = nominativo

    def __str__(self):
        print(f"{str(self.nominativo)}:", end=" ")
        for i in range(0,len(self.MATERIE)):
            print(f"{str(self.MATERIE[i])}={str(self.voti[i])}", end=",")

    def aggiungiVoto(self, materia:str, voto:int):
        indiceMateria = self.MATERIE.index(materia)
        self.voti[indiceMateria].append(voto)
        print("Voto aggiunto a ", self.MATERIE[indiceMateria])

    def mediaVoti(self):
        print("La media generale di ", self.nominativo, "è: ")
        somma = 0
        for i in range(0, self.voti):
            for j in range(0, self.voti[i]):
                somma+=self.voti[i][j]

        media = somma / i   
        print(str(media))



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

def menu():
    pass

if __name__ == "__main__":
    classe = [Studente("Diego Ciprietti"), Studente("Marco Mainini"), Studente("Tommaso Malfasi"), Studente("Francesco Concu")]
    
    
    scelta = -1
    while (scelta != 0):
        scelta = inputMenu()
        menu(scelta)

    exit()


