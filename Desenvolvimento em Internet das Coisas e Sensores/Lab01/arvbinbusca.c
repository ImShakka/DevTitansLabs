#include <stdio.h>
#include <stdlib.h>

struct arv {
  int info;
  struct arv* esq;
  struct arv* dir;
};

typedef struct arv Arv;

Arv* busca (Arv* r, int v)
{
  if (r == NULL) return NULL;
  else if (r->info > v) return busca(r->esq,v);
  else if (r->info < v) return busca(r->dir,v);
  else return r;
}


Arv* insere (Arv* a, int v)
{
  if (a==NULL) {
    a = (Arv*)malloc(sizeof(Arv));
    a->info = v;
    a->esq = a->dir = NULL;
  }
  else if (v < a->info)
    a->esq = insere(a->esq,v);
  else /* v < a->info */
    a->dir = insere(a->dir,v);
  return a;
}


Arv* libera (Arv* a){
  if (!vazia(a)){
    libera(a->esq); /* libera sae */
    libera(a->dir); /* libera sad */
    free(a); /* libera raiz */
  }
  return NULL;
}


void imprime_in (Arv* r)
{
  if(!vazia(r))
    imprime_in(r->esq);
    printf("%d ", r->info);
    imprime_in(r->dir);
}



void main(void)
{
  Arv* a = NULL;
  int elementos[] = {1, 2, 3, 5, 15, 7};
  int i;

  for(i=0; i < 6; i++){
    printf("inserindo %d...\n", elementos[i]);
    a = insere(a, elementos[i]);
    printf("arvore in-fixada: ");
    imprime_in(a);
    printf("\n\n");
  }

  printf("buscando o elemento 2...\n");
  if(busca(a, 2)){
    printf("elemento 2 encontrado.\n");
  } else {
    printf("elemento 2 nao encontrado.\n");
  }
    
  printf("buscando o elemento 8...\n");
  if(busca(a, 8)){
    printf("elemento 8 encontrado.\n");
  } else {
    printf("elemento 8 nao encontrado.\n");
  }

  libera(a);
}
