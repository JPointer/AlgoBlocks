/* FUNC x=0, y=0, w=0, h=0, p=0; */
int func (int a, int b, int a_____awdw) {
    /* RET x=0, y=0, w=0, h=0, p=0; */
    return a *(-1);
}

/* FUNC x=0, y=0, w=0, h=0, p=0; */
int func2 (int a1, int b1, int a111_____awdw) {
    /* RET x=0, y=0, w=0, h=0, p=0; */
    return a1 *(-1);
}

/* MAIN x=1, y=2, w=3, h=4, p=5;*/
int main(){
    /* DECL x =1, y=2, w=3, h=4, p=5; */
    int a;

    /* DECL x =1, y=2, w=3, h=4, p=5; */
    int c;

    /* READ x =1, y=2, w=3, h=4, p=5; */
    read(a);

     /* ASSIGN x=1, y=2, w=3, h=4, p=5; */
     a = a + 1;

    /*
    IF x=1, y=2, w=3, h=4, p=5;
    TRUE x=1, y=2, w=3, h=4, p=5;
    ELSE x=1, y=2, w=3, h=4, p=5; */
    if ( a >3) {
        /* ASSIGN x=1, y=2, w=3, h=4, p=5; */
        a = c + 1;
    }
    else {
        /*
        WHILE x=1, y=2, w=3, h=4, p=5;
        WHILEOP x=1, y=2, w=3, h=4, p=5; */
        while ( a <10 && a < 14) {
            /* ASSIGN x=1, y=2, w=3, h=4, p=5; */
            a = (a + 1)+((c + 10) - (a * c - 1));
        }
    }

    /* WRITE x=1, y=2, w=3, h=4, p=5; */
    write(c);

    /* DECL x=1, y=2, w=3, h=4, p=5; */
    int b = func(k) ;

    /* WRITE x=1, y=2, w=3, h=4, p=5; */
    write (b) ;

    /* RET x=1, y=2, w=3, h=4, p=5; */
    return a;
}