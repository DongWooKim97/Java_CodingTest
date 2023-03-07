class Solution {
    public int solution(int hp) {
        int general = 0;
        int soldier = 0;
        int worker;

        general += hp / 5;
        hp %= 5;

        soldier += hp / 3;
        hp %= 3;

        worker = hp;

        return general + soldier + worker;
    }

}