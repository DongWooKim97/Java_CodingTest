class Solution {
    public int solution(int n) {
        return (n + "") // "123"
                .chars() // "123" => IntStream[49,50,51]
                .map(Character::getNumericValue)  // IntStream[1, 2, 3]
                .sum(); // 1+2+3 -> 6

    }
}