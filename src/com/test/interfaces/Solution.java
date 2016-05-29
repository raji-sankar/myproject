package com.test.interfaces;

import com.intellij.profile.codeInspection.ui.AdvancedSettingsAction;

/**
 * Created by Raji on 4/9/2016.
 */
public class Solution {
}

interface AdvancedArithmetic{
    int divisorSum(int n);
}

class Calculator implements AdvancedArithmetic{
    @Override
    public int divisorSum(int n) {
        return 0;
    }
}
