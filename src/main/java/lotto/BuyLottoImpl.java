package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BuyLottoImpl implements BuyLotto{

    private final int lottoPrice;
    private final int money;
    public BuyLottoImpl(int lottoPrice, int money) {
        this.lottoPrice = lottoPrice;
        this.money = money;
    }

    @Override
    public int getLottoCount() {
        validate();
        return lottoPrice/money;
    }

    @Override
    public void validate() {
        if(money%lottoPrice!= 0){
            throw new IllegalArgumentException("[ERROR]제대로 된 값을 입력하십시오");
        }
    }

    @Override
    public ArrayList<Lotto> buyLotto() {
        int lottoCount = getLottoCount();
        ArrayList<Lotto> lottos = new ArrayList<>();
        addLottos(lottoCount, lottos);
        return lottos;
    }

    private void addLottos(int lottoCount, ArrayList<Lotto> lottos) {
        for(int i = 0; i< lottoCount; i++){
            Lotto lotto = new Lotto(getLottoNumber());
            lottos.add(lotto);
        }
    }

    @Override
    public List<Integer> getLottoNumber() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1,45,6);
        return numbers;
    }

}
