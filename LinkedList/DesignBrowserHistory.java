/*
 * You have a browser of one tab where you start on the homepage and you can
 * visit another url, get back in the history number of steps or move forward in
 * the history number of steps.
 * 
 * Implement the BrowserHistory class:
 * 
 * BrowserHistory(string homepage) Initializes the object with the homepage of
 * the browser.
 * void visit(string url) Visits url from the current page. It clears up all the
 * forward history.
 * string back(int steps) Move steps back in history. If you can only return x
 * steps in the history and steps > x, you will return only x steps. Return the
 * current url after moving back in history at most steps.
 * string forward(int steps) Move steps forward in history. If you can only
 * forward x steps in the history and steps > x, you will forward only x steps.
 * Return the current url after forwarding in history at most steps.
 */

public class DesignBrowserHistory {
    class Node {
        String data;
        Node next;
        Node prev;

        Node() {
        }

        Node(String data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }

        Node(String data, Node next, Node prev) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }

    Node currentPage;

    public DesignBrowserHistory(String homepage) {
        currentPage = new Node(homepage);
    }

    public void visit(String url) {
        Node newNode = new Node(url);
        currentPage.next = newNode;
        newNode.prev = currentPage;
        currentPage = newNode;
    }

    public String back(int steps) {
        while (steps > 0) {
            if (currentPage.prev != null) {
                currentPage = currentPage.prev;
            } else {
                break;
            }
            steps--;
        }
        return currentPage.data;
    }

    public String forward(int steps) {
        while (steps > 0) {
            if (currentPage.next != null) {
                currentPage = currentPage.next;
            } else {
                break;
            }
            steps--;
        }
        return currentPage.data;
    }

    public static void main(String[] args) {
        DesignBrowserHistory browserHistory = new DesignBrowserHistory("epsilon.com");
        browserHistory.visit("inertia.com");
        browserHistory.visit("unleashed.com");
        System.out.println(browserHistory.back(1));
        System.out.println(browserHistory.back(1));
        System.out.println(browserHistory.forward(1));
        browserHistory.visit("fitoor.com");
        System.out.println(browserHistory.forward(7));
        browserHistory.visit("darksociety.com");
        System.out.println(browserHistory.back(2));
    }
}

// class BrowserHistory {

// String[] history;
// int currentPage;
// int maxPage;

// public BrowserHistory(String homepage) {
// currentPage = 0;
// maxPage = 0;
// history = new String[101];
// history[currentPage] = homepage;
// }

// public void visit(String url) {
// currentPage++;
// history[currentPage] = url;
// maxPage = currentPage;
// }

// public String back(int steps) {
// currentPage = Math.max(0, currentPage - steps);
// return history[currentPage];
// }

// public String forward(int steps) {
// currentPage = Math.min(maxPage, currentPage + steps);
// return history[currentPage];
// }
// }