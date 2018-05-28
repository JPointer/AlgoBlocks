/* FUNC x=0, y=0, w=0, h=0, p=0; */
int func (int a, int b, int c) {
    /* RET x=0, y=0, w=0, h=0, p=0; */
    return a *(-1);
}

/* FUNC x=0, y=0, w=0, h=0, p=0; */
int func (int a, int b) {
    /* RET x=0, y=0, w=0, h=0, p=0; */
    return 0;
}

/* MAIN x=1, y=2, w=3, h=4, p=5;*/
int main(){
    /* DECL x =1, y=2, w=3, h=4, p=5; */
    int a;

    /* ASSIGN x=1, y=2, w=3, h=4, p=5; */
     a = func(a, a, a, a);


    /* RET x=1, y=2, w=3, h=4, p=5; */
    return 0;
}