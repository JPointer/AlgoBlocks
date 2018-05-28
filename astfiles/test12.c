/* FUNC x=0, y=0, w=0, h=0, p=0; */
int equals (int a, int b) {

    /* DECL x =1, y=2, w=3, h=4, p=5; */
    int c;

    /*
    IF x=1, y=2, w=3, h=4, p=5;
    TRUE x=1, y=2, w=3, h=4, p=5;
    ELSE x=1, y=2, w=3, h=4, p=5; */
    if ( a == b) {
        /* ASSIGN x=1, y=2, w=3, h=4, p=5; */
        c = 1;
    }
    else {
        /* ASSIGN x=1, y=2, w=3, h=4, p=5; */
        c = 0;
    }

    /* RET x=0, y=0, w=0, h=0, p=0; */
    return c;
}

/* MAIN x=1, y=2, w=3, h=4, p=5;*/
int main(){

    /* RET x=1, y=2, w=3, h=4, p=5; */
    return equals(1, 1);
}