1. Expression	Description
2. hasRole([role])	Returns true if the current principal has the specified role.
3. hasAnyRole([role1,role2])	Returns true if the current principal has any of the supplied roles (given as a comma-separated list of strings)
4. principal	Allows direct access to the principal object representing the current user
5. authentication	Allows direct access to the current Authentication object obtained from the SecurityContext
6. permitAll	Always evaluates to true
7. denyAll	Always evaluates to false
8. isAnonymous()	Returns true if the current principal is an anonymous user
9. isRememberMe()	Returns true if the current principal is a remember-me user
10. isAuthenticated()	Returns true if the user is not anonymous
11. isFullyAuthenticated()	Returns true if the user is not an anonymous or a remember-me user
*   < &lt; &#60; 小于号
*   > &gt; &#62; 大于号
*   ≤ &le; &#8804; 小于等于号 
*   ≥ &ge; &#8805; 大于等于号 