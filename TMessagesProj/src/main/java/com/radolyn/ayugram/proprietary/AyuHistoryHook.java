package com.radolyn.ayugram.proprietary;

import android.util.SparseArray;
import org.telegram.messenger.MessageObject;
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

    public static MinMaxIds getMinAndMaxIds(ArrayList<MessageObject> messArr) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        if (messArr != null) {
            for (MessageObject obj : messArr) {
                int id = obj.messageOwner.id;
                if (id < min) min = id;
                if (id > max) max = id;
            }
        }
        return new MinMaxIds(min, max);
    }

    public static void doHook(int currentAccount, ArrayList<MessageObject> messArr,
                               SparseArray<MessageObject> messagesDict,
                               int startId, int endId, long dialogId,
                               int limit, int topicId, boolean isSecretChat) {
        // Stub - does nothing in open-source build
    }
}
