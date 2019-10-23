/**
 * 1. 什么是背包问题：（动态规划常考点）给一个背包，背包有一定的容量，在不超过背包容量的情况下最多可以拿多少物品
 *    1.1: 0-1背包：给一些物品，这些物品都只能取一次。
 *    1.2: 完全背包：给一些物品，这些物品都能取无穷多次。
 *    1.3: 多重背包：给一些物品，每个物品都有一些数量，对于这些物品，取它不能超过这些数量。
 *    
 * 2. 0-1背包：
 * 	  2.1: 暴力搜索：分别枚举每一个物体取或者不取 （eg: lintcode: 125. backpackII）
 * 	  2.2: DP:dp[i][j] = max(dp[i-1][j-A[i]] + V[i], dp[i-1][j])  (j-A[i]>=0)
 *            dp[i-1][j-A[i]]: 取i物品,容量不超过j-A[i]的最大价值
 *            dp[i-1][j]: 不取i物品,容量不超过j的最大价值
 *    2.3: exercise: 
 *         Lintcode 125. backpackII
 *         Lintcode 92. Backpack, 
 *         Lintcode 563. Backkpack V, 
 *         Lintcode 800. Backpack IX
 * 		   Lintcode 1538. Card Game II
 * 
 * 3. 完全背包：
 *    3.1 DP:枚举每件物品取0, 1, 2, 3...m/A[i]件，
 *           dp[i][j] = max(dp[i-1][j-k*A[i]] + k*V[i], dp[i-1][j])  (j-k*A[i]>=0)
 *           dp[i-1][j-k*A[i]]: 取i物品k次，容量不超过j-k*A[i]的最大价值 
 *           dp[i-1][j]: 不取i物品,容量不超过j的最大价值 
 * 
 * 
 * 4. 多重背包：
 */
/**
 * @author wendi
 *
 */
package backpack_problems;