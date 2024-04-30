// ******************************************
//  Classe abstrata ListTAD
// ******************************************

class ListTAD {
    public:
        virtual void add(int element) = 0;
        virtual void add(int index, int element) = 0;
        virtual int get(int index) = 0;
        virtual int set(int index, int element) = 0;
        virtual bool remove(int element) = 0;
        virtual int removeByIndex(int index) = 0;
        virtual bool isEmpty() = 0;
        virtual int size() = 0;
        virtual bool contains(int element) = 0;
        virtual int indexOf(int element) = 0;
        virtual void clear() = 0;
};

