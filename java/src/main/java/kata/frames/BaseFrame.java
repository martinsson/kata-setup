package kata.frames;

import kata.Frame;

public abstract class BaseFrame implements Frame {
    
    // internal business, only frames should know about it
    protected abstract int nextTwoBalls();
    protected abstract int getFirst();
    
    // must be used to finalize construction, 
    // introduces implicit temporary coupling
    public abstract void setNext(BaseFrame nextFrame);
    
}