package com.alkor.vph.vk;

import com.alkor.vph.vk.VKTokenProvider;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Author: akorobitsyn
 * Date: 03.07.13
 * Time: 14:53
 */
public class VKTokenProviderImpl implements VKTokenProvider {

    private List<String> tokens = new ArrayList<String>();
    private int index = 0;

    public static VKTokenProviderImpl createInstance(String... tokens) {
        return new VKTokenProviderImpl(Arrays.asList(tokens));
    }

    public static VKTokenProviderImpl createInstance(List<String> tokens) {
        return new VKTokenProviderImpl(tokens);
    }

    private VKTokenProviderImpl(List<String> tokens) {
        this.tokens.addAll(tokens);
    }

    @Override
    public String getToken() {
        return tokens.get(index);
    }

    @Override
    public boolean switchToken() {
        index++;
        if (index >= tokens.size()) {
            return false;
        }
        return true;
    }
}
