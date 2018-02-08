#include <bits/stdc++.h>
using namespace std;
struct node
{
    int data;
    struct node *left;
    struct node *right;
};

struct node *insert(struct node *root,int data)
{
    struct node *ptr;
    if(root==NULL)
    {
        ptr=new struct node;
        ptr->data=data;
        ptr->left=NULL;
        ptr->right=NULL;
        root=ptr;
        return root;
    }
    else
    {
        
        queue<struct node *>q;
        q.push(root);
       
        while(!q.empty())
        {
             
           struct node *temp=q.front();
           q.pop();
            if(temp->left==NULL)
            {
                ptr=new struct node;
                ptr->data=data;
                ptr->left=NULL;
                ptr->right=NULL;
                temp->left=ptr;
                break;
            }
            else if(temp->right==NULL)
            {
                ptr=new struct node;
                ptr->data=data;
                ptr->left=NULL;
                ptr->right=NULL;
                temp->right=ptr;
              break;
               
            }
            else
            {
                    if(q.empty())
                    {
                        q.push(temp->left);
                        q.push(temp->right);
                    }
            }
        }
    }
   
}
void preOrder(struct node *root)
{
    if(root==NULL)
    return;
    cout<<root->data<<" ";
    preOrder(root->left);
    preOrder(root->right);
}
int main() {
	// your code goes here
	struct node *root=NULL;
	int data,n;
	cin>>n;
	cin>>data;
	root=insert(root,data);
	for(int i=1;i<n;i++)
	{
	    cin>>data;
	    insert(root,data);
	}
	preOrder(root);
	return 0;
}
