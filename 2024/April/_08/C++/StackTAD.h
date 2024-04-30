// ******************************************
//  Classe abstrata StackTAD
// ******************************************

class StackTAD {
    public:
        virtual void push(int e) = 0;
        virtual int pop() = 0;
        virtual int top() = 0;
        virtual void clear() = 0;
        virtual bool isEmpty() = 0;
        virtual int size() = 0;
};

