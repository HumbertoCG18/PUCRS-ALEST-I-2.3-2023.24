// ******************************************
//  Classe abstrata QueueTAD
// ******************************************

class QueueTAD {
    public:
        virtual void enqueue(int e) = 0;
        virtual int dequeue() = 0;
        virtual int head() = 0;
        virtual void clear() = 0;
        virtual bool isEmpty() = 0;
        virtual int size() = 0;
};

