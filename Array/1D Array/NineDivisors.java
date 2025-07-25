/*
++++++++++++++++++++++++++++++++  QUESTION & EXAMPLE  ++++++++++++++++++++++++++++++++++++++++++++++++++
Given a positive integer n, you need to count the numbers less than or equal to n having exactly 9 divisors.

Example :
Input: n = 100
Output: 2
Explanation: Numbers which have exactly 9 divisors are 36 and 100.

++++++++++++++++++++++++++++++++  APPROACH  ++++++++++++++++++++++++++++++++++++++++++++++++++

An efficient approach is to use the property of the prime factor to count the number of divisors of a number. The method can be found here. 
If any number (let X) can be expressed in terms of (p2 * q2) or (p8), where p and q are prime factors of X, then X has a total of 9 divisors. 

Proof:

A number X has exactly 9 positive divisors if and only if the total number of divisors of X is 9.
The number of divisors of a number X = p1e1 * p2e2 * … * pk ​​ is given by:
Total Divisors = (e1+1) (e2+1) … (ek+1)
To get exactly 9 divisors, the product of these (ei+1)'s must be 9.

Possible Factorizations of 9:

9 = 9⇒ e1 = 8 ⇒ p8
9 = 3 × 3 ⇒ e1 = 2, e2 = 2 ⇒X=p2 * q2 where p ≠ q.
So the number X has exactly 9 positive divisors if and only if:

X=p8, or
X=p2 * q2, where p and q are distinct primes
The below steps can be followed to solve the above problem. 

Step By Step Approach

Use Sieve technique to mark the smallest prime factor of a number.
We just need to check for all the numbers in the range[1-sqrt(n)] that can be expressed in terms of p*q since (p^2*q^2) has 9 factors, hence (p*q)^2 will also have exactly 9 factors.
Iterate from 1 to sqrt(n) and check if i can be expressed as p*q, where p and q are prime numbers.
Also, check if i is prime then pow(i, 8)<=n or not, in that case, count that number also.
The summation of the count of numbers that can be expressed in the form p*q and p^8 is our answer.

🌐 Resource (ctrl + click) :: https://www.geeksforgeeks.org/dsa/count-number-of-integers-less-than-or-equal-to-n-which-has-exactly-9-divisors/
 */

class Solution {
    public static int countNumbers(int n) {
        // code here
         int count = 0;
        int sqrtLimit = (int)Math.sqrt(n);

        int[] smallestPrimeFactor = new int[sqrtLimit + 1];

        // Initialize smallestPrimeFactor[i] = i
        for (int i = 1; i <= sqrtLimit; i++) {
            smallestPrimeFactor[i] = i;
        }

        // Sieve to store the smallest prime factor for every number
        for (int i = 2; i * i <= sqrtLimit; i++) {
            if (smallestPrimeFactor[i] == i) {
                for (int j = i * i; j <= sqrtLimit; j += i) {
                    if (smallestPrimeFactor[j] == j) {
                        smallestPrimeFactor[j] = i;
                    }
                }
            }
        }

        for (int i = 2; i <= sqrtLimit; i++) {
            int prime1 = smallestPrimeFactor[i];
            int prime2 = smallestPrimeFactor[i / prime1];

            // Check for the form p^2 * q^2 where p and q are distinct primes
            if (prime1 * prime2 == i && prime2 != 1 && prime1 != prime2) {
                count += 1;
            }
            // Check for the form p^8
            else if (smallestPrimeFactor[i] == i && Math.pow(i, 8) <= n) {
                count += 1;
            }
        }

        return count;
    }
}