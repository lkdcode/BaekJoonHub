class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int maxAttackIndex = attacks.length;
        int maxHealth = health;

        int castingTime = bandage[0];
        int recoveryTimePerSecond = bandage[1];
        int bonusRecoveryTimePerSecond = bandage[2];

        int startTime = 0;
        int attackIndex = 0;
        int consecutiveSuccessCount = 0;

        while (attackIndex < maxAttackIndex) {
            int[] attackInformation = attacks[attackIndex];
            int attackTime = attackInformation[0];
            int attackDamage = attackInformation[1];

            if (startTime == attackTime) {
                attackIndex++;

                consecutiveSuccessCount = 0;
                health -= attackDamage;
                if (health <= 0) {
                    return -1;
                }
            } else {
                consecutiveSuccessCount++;
                health += recoveryTimePerSecond;
                if (health > maxHealth) health = maxHealth;
            }

            if (consecutiveSuccessCount == castingTime) {
                consecutiveSuccessCount = 0;
                health += bonusRecoveryTimePerSecond;
                if (health > maxHealth) health = maxHealth;
            }

            startTime++;
        }

        return health;
    }
}