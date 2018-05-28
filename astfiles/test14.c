/* FUNC x=0, y=0, w=0, h=0, p=0; */
int factorial (int a) {
    /* DECL x =1, y=2, w=3, h=4, p=5; */
    int c = 1;

    /*
    WHILE x=1, y=2, w=3, h=4, p=5;
    WHILEOP x=1, y=2, w=3, h=4, p=5; */
    while ( a > 1) {
        /* ASSIGN x=1, y=2, w=3, h=4, p=5; */
        c = c * a;

        /* ASSIGN x=1, y=2, w=3, h=4, p=5; */
        a = a - 1;
    }

    /* RET x=0, y=0, w=0, h=0, p=0; */
    return c;
}

/* MAIN x=1, y=2, w=3, h=4, p=5;*/
int main(){

    /* RET x=1, y=2, w=3, h=4, p=5; */
    return factorial(5);
}