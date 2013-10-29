/**
 *The constructor for CountList, sets the head to NULL
 */

template <typename T>
CountList<T>::CountList()
{
    head = NULL;
}

/**
 * The deconstructor goes through and deletes all the dynamically allocated data one by one starting with head and going until it hits null.
 *
 * temp Of type Node of Count that is set to head to erase all allocated data.
 */

template <typename T>
CountList<T>::~CountList()
{
    Node<Count<T> >* temp = head;
    while (head != NULL) {
        temp = head -> getNext();
        delete head;
        head = temp;
    }
    numItemsStored = 0;
}

/**
 * The copy constructor, basically using the bump count goes through and copies all the data to temp from head.
 * 
 * @param c the list called in
 */

template <typename T>
CountList<T>::CountList(const CountList<T>& c)
{
    head = NULL;
    Node<Count<T> >* temp = c.head;
    while (temp != NULL) {
        T t = temp->getItem().getItem();
        int num = temp->getItem().getCount();
        for (int i = 0; i < num; i++)
            bumpCount(t);
        temp = temp->getNext();
    }
}

/**
 * The bumpCount now goes through and based on the position, places the item into its spot on the linked list.
 *
 * @param t The item of type t getting placed into the linked list
 */
template <typename T>
void CountList<T>::bumpCount(T t)
{
    //Node<Count<T> >* temp = NULL;
    bool found;
    
    Node<Count<T> >* pos = checkAndSet(head, t, found);
    if (found)
    {
        Count<T> ti = pos->getItem();
        ti.increment();
        pos->setItem(ti);
    }
    else // need to add a new Node
    {
        Count<T> ti(t);
        Node<Count<T> >* n = new Node<Count<T> >(ti);
        if (pos == NULL) // this becomes new head of list
        {
            n->setNext(head);
            head = n;
        }
        else // must follow "pos"
        {
            n->setNext(pos->getNext());
            pos->setNext(n);
        }
    }

}

/**
 * Goes Through and finds where and how to set the new item into the list either in the front, middle or end.
 *
 * @param head The list being checked
 * @param t The item being placed
 * @param found A bool statement to help decided where to place whether its true or false
 */

template <typename T>
Node<Count<T> >* CountList<T>::checkAndSet(Node<Count<T> >* head, T t, bool& found)
{
    Node<Count<T> >* cur = head;
	Node<Count<T> >* prev = NULL;
    bool check = false;
    
    while(cur != NULL)
    {
        if (cur -> getItem().getItem() == t) {
            found = true;
            return cur;
        }
        if (cur->getItem().getItem() > t)
		{
			found = false;
			return prev;
		}
		prev = cur;
		cur = cur->getNext();
	}
    found = false;
	return prev;
}

/**
 * returns a new Count object
 */
template <typename T>
Count<T> CountList<T>::newCount(T t) const
{
	Count<T> x(t);
	return x;
}

/**
 * Returns a CountList<T> numItemsStored.
 */

template <typename T>
int CountList<T>::getNumItemsStored() const
{
	return numItemsStored;
}

/**
 * prints out the linked list.
 */

template<typename T>
void CountList<T>::print()
{
	Node<Count<T> >* temp = head;
    while (temp != NULL){
        std::cout << "(" << temp->getItem().getItem() << ", " <<temp->getItem().getCount() << ")" << "\n";
        temp = temp ->getNext();
    }
    
    
}

