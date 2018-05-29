/* FUNC x=0, y=0, w=0, h=0, p=0; */
int func (int a) {
    /* RET x=0, y=0, w=0, h=0, p=0; */
    return a *(-1);
}

/* MAIN x=1, y=2, w=3, h=4, p=5;*/
int main(){
    /* DECL x =1, y=2, w=3, h=4, p=5; */
    int a = 5;

    /* READ x =1, y=2, w=3, h=4, p=5; */
    read(a);

    /*
    IF x=1, y=2, w=3, h=4, p=5;
    TRUE x=1, y=2, w=3, h=4, p=5;
    ELSE x=1, y=2, w=3, h=4, p=5; */
    if ( a >3) {
        /* ASSIGN x=1, y=2, w=3, h=4, p=5; */
        a = a +2;
    }
    else {
        /* ASSIGN x=1, y=2, w=3, h=4, p=5; */
        a = a + 1;

        /*
        WHILE x=1, y=2, w=3, h=4, p=5;
        WHILEOP x=1, y=2, w=3, h=4, p=5; */
        while ( a <10 ) {
            /* ASSIGN x=1, y=2, w=3, h=4, p=5; */
            a = a + 1;
        }
    }

    /* WRITE x=1, y=2, w=3, h=4, p=5; */
    write(a);

    /* DECL x=1, y=2, w=3, h=4, p=5; */
    int b = func(a) ;

    /* WRITE x=1, y=2, w=3, h=4, p=5; */
    write (b) ;

    /* RET x=1, y=2, w=3, h=4, p=5; */
    return 0;
}