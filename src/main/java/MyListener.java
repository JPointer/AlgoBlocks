import parser.AlgoBlocksBaseListener;
import parser.AlgoBlocksParser;

public class MyListener extends AlgoBlocksBaseListener {

    @Override
    public void enterOrExpr(AlgoBlocksParser.OrExprContext ctx) {
        System.out.println(ctx.getText());
    }

}
