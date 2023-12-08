// PlaceHolderController.java
// By Zee Fisher
//  _________________________________________
// < This one's cause not everything's done! >
//  -----------------------------------------
//         \   ^__^
//          \  (oo)\_______
//             (__)\       )\/\
//                 ||----w |
//                 ||     ||

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Simple ActionListeners for the placeholder view.
 */
class PlaceHolderController {

	/** 
	* Cosntructs PlaceHolderController singleton 
	*/
        private PlaceHolderController() {}

        /**
         * Creates listener to return to login menu.
         * @return ActionListener that return to login menu
         */
        public ActionListener loginButtonListener() {
                return new ActionListener () {
                        public void actionPerformed(ActionEvent e) {
                                PlaceHolderView.getInstance().hide();
                                LoginView.getInstance().show();
                        }
                };
        }

	/**
	 * Gets the PHC's instance
	 * @return PlaceHolderController
	 */
        public static PlaceHolderController getInstance() {
                return instance;
        }

        private static PlaceHolderController instance = new PlaceHolderController();
}

