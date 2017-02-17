package com.ys.ts.fuck_money.model;

import android.text.TextUtils;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.ListView;
/**
 * 红包节点信息
 * 用于判断红包是否有效
 * Created by nufeng on 1/3/17.
 */

public class FMMoneyNodeInfo {
    public AccessibilityNodeInfo parent;
    public AccessibilityNodeInfo listParent;
    public AccessibilityNodeInfo mNode;
    public Signature signature;//用于做次红包唯一性判断
    private int indexInParent;

    public FMMoneyNodeInfo(AccessibilityNodeInfo node) {
        mNode = node;
        getListParent(node);
        makeSignature();
    }

    private void makeSignature() {
        signature = new Signature();
        signature.sChild = getChildPart(mNode);
        signature.sParentUp = getUpParentPart();
        signature.sParentDown = getDownParent();
    }

    private int getIndex(){
        for (int i = 0, j = listParent.getChildCount(); i<j; i++){
            if (listParent.getChild(i) ==null)
                continue;
            if (listParent.getChild(i)==parent){
                return i;
            }
        }
        return -1;
    }

    private String getUpParentPart(){
        if (indexInParent-1>=0){
            AccessibilityNodeInfo up = listParent.getChild(indexInParent-1);
            return getChildPart(up);
        }
        return null;
    }
    private String getDownParent(){
        if (listParent.getChildCount()>indexInParent+1){
            AccessibilityNodeInfo down = listParent.getChild(indexInParent+1);
            return getChildPart(down);
        }
        return null;
    }

    private void getListParent(AccessibilityNodeInfo node) {
        if (node.getClassName().equals(ListView.class.getSimpleName())) {
            parent = node;
            listParent = node.getParent();
            indexInParent = getIndex();
        } else {
            getListParent(node);
        }
    }

    private String getChildPart(AccessibilityNodeInfo info) {
        String s = "";
        if (info.getChildCount() == 0 && !TextUtils.isEmpty(info.getText())) {
            s = info.getText().toString();
        } else {
            for (int i = 0, j = info.getChildCount(); i < j; i++) {
                AccessibilityNodeInfo c = info.getChild(i);
                s += getChildPart(c);
            }
        }
        return s;
    }

    /**
     * 签名分为两部分，
     * 一部分是子节点以及兄弟节点组成的信息，
     * 一部风是父节点以及父兄弟节点组成的信息
     *      父兄弟节点包括上节点和下节点
     */
    static class Signature {
        public String sChild;
        public String sParentUp;
        public String sParentDown;
    }
}
