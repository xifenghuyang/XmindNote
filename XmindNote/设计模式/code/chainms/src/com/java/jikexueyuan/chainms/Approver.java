package com.java.jikexueyuan.chainms;

/**
 * 处理者，决策者，批准人
 */
public abstract class Approver {
    // 后续处理者，后继者
    Approver successor; // 指针用来指向下一个处理者
    String Name;

    public Approver(String Name) {
        this.Name = Name;
    }

    // 抽象函数，子类中具体化
    public abstract void ProcessRequest(PurchaseRequest request);

    // 设置后继处理者
    public void SetSuccessor(Approver successor) {
        // TODO Auto-generated method stub
        this.successor = successor;
    }
}
