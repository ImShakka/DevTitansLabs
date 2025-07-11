#include <stdio.h>
#include <stdlib.h>

struct arv {
  int info;
  struct arv* esq;
  struct arv* dir;
};

typedef struct arv Arv;

Arv* inicializa(void)
{
  return NULL;
}

Arv* cria(int c, Arv* sae, Arv* sad)
{
  Arv* p=(Arv*)malloc(sizeof(Arv));
  p->info = c;
  p->esq = sae;
  p->dir = sad;
  return p;
}

int vazia(Arv* a)
{
  return a==NULL;
}

Arv* libera (Arv* a){
  if (!vazia(a)){
    libera(a->esq); /* libera sae */
    libera(a->dir); /* libera sad */
    free(a); /* libera raiz */
  }
  return NULL;
}

Arv* busca (Arv* r, int v)
{
  if (r == NULL) return NULL;
  if (r->info == v) return r;
  
  Arv* t = busca(r->esq, v);
  if (t != NULL) return t;
  
  return busca(r->dir, v);
}

void imprime_pre (Arv* a)
{
  if (!vazia(a))
    printf("%d ", a->info);
    imprime_pre(a->esq);
    imprime_pre(a->dir);
}

void imprime_in (Arv* a)
{
  if (!vazia(a))
    imprime_in(a->esq);
    printf("%d ", a->info);
    imprime_in(a->dir);
}

void imprime_pos (Arv* a)
{
  if (!vazia(a))
  imprime_pos(a->esq);
  imprime_pos(a->dir);
  printf("%d ", a->info);
}

int main()
{
	Arv* a = cria(45, cria(5, cria(12, inicializa(), inicializa()), cria(34, inicializa(), cria(67, inicializa(), inicializa()))), cria(80, inicializa(), cria(40, inicializa(), inicializa())));

    printf("impressao pre-fixada:\n");
    imprime_pre(a);
    printf("\nimpressao in-fixada:\n");
    imprime_in(a);
    printf("\nimpressao pos-fixada:\n");
    imprime_pos(a);

    Arv* no80 = busca(a, 80);
    if(no80 != NULL)
        libera(no80->esq);
        no80->esq = cria(66, cria(3, inicializa(), inicializa()), cria(31, inicializa(), inicializa()));
    
    printf("\n\nimpressao pre-fixada apos enxerto:\n");
    imprime_pre(a);
    printf("\nimpressao in-fixada apos enxerto:\n");
    imprime_in(a);
    printf("\nimpressao pos-fixada apos enxerto:\n");
    imprime_pos(a);
    
    if (a->esq != NULL && a->esq->info == 5)
        libera(a->esq);
        a->esq = NULL;

    printf("\n\nimpressao pre-fixada apos poda:\n");
    imprime_pre(a);
    printf("\nimpressao in-fixada apos poda:\n");
    imprime_in(a);
    printf("\nimpressao pos-fixada  apos poda:\n");
    imprime_pos(a);

	libera(a);
	
	return 0;
}
