/* FUNC x=0, y=0, w=0, h=0, p=0; */
int func (int a, int b) {
    /* RET x=0, y=0, w=0, h=0, p=0; */
    return (a*a + b);
}

/* MAIN x=1, y=2, w=3, h=4, p=5;*/
int main(){

    /* RET x=1, y=2, w=3, h=4, p=5; */
    return func(2, 3);
}