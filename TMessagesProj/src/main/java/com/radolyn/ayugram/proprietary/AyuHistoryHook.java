package com.radolyn.ayugram.proprietary;

import android.util.SparseArray;
import java.util.ArrayList;

public class AyuHistoryHook {

    public static class MinMaxIds {
        public int first;
        public int second;
        public MinMaxIds(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public static MinMaxIds getMinAndMaxIds(ArrayList<?> messArr) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        if (messArr != null) {
            for (Object obj : messArr) {
                try {
                    Object owner = obj.getClass().getField("messageOwner").get(obj);
                    int id = (int) owner.getClass().getField("id").get(owner);
                    if (id < min) min = id;
                    if (id > max) max = id;
                } catch (Exception ignored) {}
            }
        }
        return new MinMaxIds(min, max);
    }

    @SuppressWarnings("unchecked")
    public static void doHook(int currentAccount, ArrayList<?> messArr,
                               SparseArray<?>[] messagesDict,
                               int startId, int endId, long dialogId,
                               int limit, int topicId, boolean isSecretChat) {
    }
}
