#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <time.h>
#include <string.h>

#define DIM 5

typedef struct{
    int x;
    int y;
    int quadrante;
    int flag_cancellato;
}punto;

void caricaValori(punto[]);
int scelta();
void menu(int,punto[]);
void es1(punto[]);
void es2(punto[]);
void es3(punto[]);
void es4(punto[]);
void es5(punto *min, punto *max, punto[], float[]);
void es6(punto[]);
int confrontaDistanza(punto p1, punto p2);
int confrontaDistanzaQuadrante(punto p1, punto p2);
int confrontaDistanzaQuadrante(punto p1, punto p2);

int main()
{
    srand(time(NULL));
    
    punto database[DIM];
    
    caricaValori(database);
    int s;
    
    
    do{
        s=scelta();
        menu(s,database);
    } while(s != 0);
    
    
    
    return 0;
}


void caricaValori(punto database[]){
    for(int i=0; i<DIM; i++){
        int random_x = (-10) + rand() % (10 - (-10) + 1);
        int random_y = (-10) + rand() % (10 - (-10) + 1);
        for (int j = 0; j < i; j++){
            while (random_x == database[j].x && random_y == database[j].y){
                random_x = (-10) + rand() % (10 - (-10) + 1);
                random_y = (-10) + rand() % (10 - (-10) + 1);
            }
        }
        database[i].x = random_x;
        database[i].y = random_y;
        if(database[i].x>0&&database[i].y>0)
            database[i].quadrante=1;
        else if(database[i].x<0&&database[i].y>0)
            database[i].quadrante=2;
        else if(database[i].x<0&&database[i].y<0)
            database[i].quadrante=3;
        else if(database[i].x>0&&database[i].y<0)
            database[i].quadrante=4;
        else 
            database[i].quadrante=0;

        printf("il punto %d ha valori: (%d,%d)\n", i, database[i].x, database[i].y);
    }
}

int scelta(){
    int scelta;
    printf("\n0. Uscire \n1. Visualizzare un punto selezionato\n2. Visualizzare tutti i punti in un certo insieme\n3. Restiruire la distanza tra due punti selezionati\n4. Restituire il punto medio tra due punti\n5. Restituire in ordine i punti piu vicino all'origine\n6. Cancellare un punto\n");
    scanf("%d",&scelta);
   
    return scelta;
}

void input(punto *p1, punto *p2, punto database[]){
    int punto1, punto2; 
    do {
        printf("inserisci punto 1: ");
        scanf("%d", &punto1);
        printf("inserisci punto 2: ");
        scanf("%d", &punto2);
    } while((punto1 < 0 || punto1 >= DIM) || (punto2 < 0 || punto2 >= DIM));
    
    (*p1) = database[punto1];
    (*p2) = database[punto2];
}



void menu(int scelta, punto database[]){
    
    switch(scelta){
        case 0: 
            printf("\nArrivederci!");
            break;
        case 1:
            es1(database);
            break;
        case 2:
            es2(database);
            break;
        case 3:
            es3(database);
            break;
        case 4:
            es4(database);
            break;
        case 5:
            float distanze[DIM];
            punto min, max;
            es5(&min,&max,database,distanze);

            printf("punto meno distante dall'origine (%d,%d) distanza: %.2f\npunto più distante dall'origine (%d,%d) distanza: %.2f",
                database[0].x, database[0].y, distanze[0], database[DIM-1].x, database[DIM-1].y, distanze[DIM-1]
            );    
            
            break;
        case 6: 
            es6(database);
            break;

        default: 
            printf("Scelta non valida! riprova");
            
    }
}

void stampa_punto(punto p, char* buffer) {
    
    const char* quadranti[] = {
        "0",   
        "Primo",       
        "Secondo",     
        "Terzo",       
        "Quarto"       
    };
    
    sprintf(buffer, "P=(%d,%d) - %s", p.x, p.y, quadranti[p.quadrante]);
}


void es1(punto database[]){
    int puntoS;
    
    do{
        printf("Quale punto vuoi Visualizzare?\t");
        scanf("%d",&puntoS);
    }while(puntoS>DIM || puntoS<0);
    
   
    printf("Il punto ha coordinate (%d,%d) e si trova nel %d quadrante",database[puntoS].x,database[puntoS].y,database[puntoS].quadrante);
}


void es2(punto database[]){
    int qS;
    char stringa_finale[50]; 
    do {
        printf("Di che quadrante vuoi Visualizzare i punti?\t");
        scanf("%d",&qS);
    } while(qS>4 || qS<0);


     for (int i=0; i<DIM; i++){
        if(database[i].quadrante == qS){
            stampa_punto(database[i], stringa_finale);
            printf("%s\n", stringa_finale);
        }
    }
    
    
}


void es3(punto database[]){
    punto p1, p2;
    int result;
    input(&p1, &p2, database);
    
    result = sqrt(pow(p2.x - p1.x, 2) + pow(p2.y - p1.y, 2));
    
    printf("La distanza è %d",result);
}


void es4(punto database[]){
    punto p1, p2;
    int result1, result2;
    input(&p1, &p2, database);
    
    result1=(p1.x + p2.x)/2;
    result2=(p1.y + p2.y)/2;
    printf("Il punto medio è (%d,%d)",result1,result2);
}

int confrontaDistanza(punto p1, punto p2) {
    float d1 = sqrt(pow(p1.x, 2) + pow(p1.y, 2));
    float d2 = sqrt(pow(p2.x, 2) + pow(p2.y, 2));

    if (d1 > d2)
        return 1;
    else if (d1 < d2)
        return -1;
    else
        return 0;
}

int confrontaDistanzaQuadrante(punto p1, punto p2) {
    float d1 = sqrt(pow(p1.x, 2) + pow(p1.y, 2));
    float d2 = sqrt(pow(p2.x, 2) + pow(p2.y, 2));

    if (d1 > d2)
        return 1;
    else if (d1 < d2)
        return -1;
    else {
        // Se la distanza è uguale, confronta il quadrante
        if (p1.quadrante < p2.quadrante)
            return -1;
        else if (p1.quadrante > p2.quadrante)
            return 1;
        else
            return 0;
    }
}

int confrontaDistanzaQuadranteStringa(punto p1, punto p2) {
    float d1 = sqrt(pow(p1.x, 2) + pow(p1.y, 2));
    float d2 = sqrt(pow(p2.x, 2) + pow(p2.y, 2));

    const char* quadranti[] = {"0", "Primo", "Secondo", "Terzo", "Quarto"};

    if (d1 > d2)
        return 1;
    else if (d1 < d2)
        return -1;
    else 
        return strcmp(quadranti[p1.quadrante], quadranti[p2.quadrante]);
    
}


void es5(punto *min, punto *max,punto database[], float distanze[]){
    
    
    punto appoggioP;

    for(int i=0;i<DIM;i++){
        distanze[i] = sqrt(pow(database[i].x, 2) + pow(database[i].y, 2));
    }
    /*
    SOLUZIONE INIZIALE CON SELECTION SORT
    int min=0;
    float appoggio;
      for(int i=0;i<DIM;i++){
        min=i;
        for(int j=i+1;j<DIM;j++){
          if(distanze[i]<distanze[min])
            min=j;
        }
        appoggio=distanze[i];
        distanze[i]=distanze[min];
        distanze[min]=appoggio;

        appoggioP = database[i];
        database[i] = database[min];
        database[min] = appoggioP;

      }
    */
   int scelta;
   printf("quale funzione vuoi usare per la condizione: \n1) confrontaDistanza \n2) confrontaDistanzaQuadrante \n3)  confrontaDistanzaQuadranteStringa");
   scanf("%d", &scelta);
   float appoggio;
   int ris;
    for(int i=0;i<DIM;i++){   
        for(int j=i+1;j<DIM;j++){
            
            if(scelta == 0)
                ris  = confrontaDistanza(database[i], database[j]);
            else if (scelta == 1)
                ris = confrontaDistanzaQuadrante(database[i], database[j]);
            else if (scelta == 2)
                ris = confrontaDistanzaQuadranteStringa(database[i], database[j]);
            


            if (ris > 0){
                appoggio=distanze[i];
                distanze[i]=distanze[j];
                distanze[j]=appoggio;

                appoggioP = database[i];
                database[i] = database[j];
                database[j] = appoggioP;
        
            }
           
                
        }
    }
    
    (*min) = database[0];
    (*max) = database[DIM-1];
}
void es6(punto database[]){
    printf("Scegli quale punto cancellare tra quelli già presenti: ");
    int punto1; 
    do {
        scanf("%d", &punto1);
        if (punto1 < 0 || punto1 >= DIM)
            printf("\nvalore non valido reinserisci un punto da scelgliere: ")
    } while(punto1 < 0 || punto1 >= DIM);
    
    database[punto1].x = -100;
    database[punto1].y = -100;
    database[punto1].quadrante = -100;
    database[punto1].flag_cancellato = 1;

    printf("punto cancellato nuovi valori: (%d,%d)", database[punto1].x, database[punto1].y);
    
}