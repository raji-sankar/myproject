package com.leet.accountsmerge;

import java.util.*;

/**
 * 721. Accounts Merge
 * Medium
 *
 * Given a list accounts, each element accounts[i] is a list of strings, where the first element accounts[i][0] is a
 * name, and the rest of the elements are emails representing emails of the account.
 *
 * Now, we would like to merge these accounts. Two accounts definitely belong to the same person if there is
 * some email that is common to both accounts. Note that even if two accounts have the same name, they may belong
 * to different people as people could have the same name. A person can have any number of accounts initially,
 * but all of their accounts definitely have the same name.
 *
 * After merging the accounts, return the accounts in the following format: the first element of each account
 * is the name, and the rest of the elements are emails in sorted order.
 * The accounts themselves can be returned in any order.
 *
 * Example 1:
 * Input:
 * accounts = [["John", "johnsmith@mail.com", "john00@mail.com"], ["John", "johnnybravo@mail.com"], ["John", "johnsmith@mail.com", "john_newyork@mail.com"], ["Mary", "mary@mail.com"]]
 * Output: [["John", 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com'],  ["John", "johnnybravo@mail.com"], ["Mary", "mary@mail.com"]]
 * Explanation:
 * The first and third John's are the same person as they have the common email "johnsmith@mail.com".
 * The second John and Mary are different people as none of their email addresses are used by other accounts.
 * We could return these lists in any order, for example the answer [['Mary', 'mary@mail.com'], ['John', 'johnnybravo@mail.com'],
 * ['John', 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com']] would still be accepted.
 * Note:
 *
 * The length of accounts will be in the range [1, 1000].
 * The length of accounts[i] will be in the range [1, 10].
 * The length of accounts[i][j] will be in the range [1, 30]
 */

public class Solution {

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, String> emailToName = new HashMap<>();
        Map<String, List<String>> graph = new HashMap<>();
        for(List<String> account: accounts){
            if (account.size() > 1){
                String name = "";
                for(String email: account){
                    if (name == ""){
                        name = email;
                        continue;
                    }
                    graph.computeIfAbsent(email, x -> new ArrayList<String>()).add(account.get(1));
                    graph.computeIfAbsent(account.get(1), x-> new ArrayList<String>()).add(email);
                    emailToName.put(email, name);
                }
            }
        }

        Set<String> seen = new HashSet<>();
        List<List<String>> ans = new ArrayList<>();
        for(String email: graph.keySet()){
            if (!seen.contains(email)){
                seen.add(email);
                Stack<String> stack = new Stack<>();
                stack.push(email);
                List<String> component = new ArrayList<>();
                while(!stack.empty()){
                    String node = stack.pop();
                    component.add(node);
                    for(String nei: graph.get(node)){
                        if(!seen.contains(nei)){
                            seen.add(nei);
                            stack.push(nei);
                        }
                    }
                }
                Collections.sort(component);
                component.add(0, emailToName.get(email));
                ans.add(component);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        List<List<String>> accounts = new ArrayList<>();
        List<String> account1 = new ArrayList<>();
        account1.add("John");
        account1.add("johnsmith@mail.com");
        account1.add("john00@mail.com");
        accounts.add(account1);
        List<String> account2 = new ArrayList<>();
        accounts.add(account2);
        List<String> account3 = new ArrayList<>();
        accounts.add(account3);
        List<String> account4 = new ArrayList<>();
        accounts.add(account4);
        account2.add("John");
        account2.add("johnnybravo@mail.com");
        account3.add("John");
        account3.add("johnsmith@mail.com");
        account3.add("john_newyork@mail.com");
        account4.add("Mary");
        account4.add("mary@mail.com");

        System.out.println(sol.accountsMerge(accounts));
    }
}
