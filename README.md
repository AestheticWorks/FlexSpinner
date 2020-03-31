# FlexSpinner
Simple, flexible spinner that includes multi-select functionality and search functionality

### Includes:
- Basic, single select spinner, for layout consistency
- Single select spinner with search functionality
- Multiple selection spinner
- Multiple selection spinner with search functionlity

### Usage

Layout:
```
<com.laurachelaru.flexspinnerlibrary.FlexSpinnerMultipleSearch
            android:id="@+id/multiple_spinner_search"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            app:hintText = "Multiple spinner search"
            app:highlightColor = "@color/colorPrimary"
            app:textColor = "@color/colorPrimaryDark"/>
```

Binding data to spinner:
```
FlexSpinnerMultipleSearch spinnerMultipleSearch = (FlexSpinnerMultipleSearch) findViewById(R.id.multiple_spinner_search);

List<FlexItem> multipleSpinnerSearchItemList = new ArrayList<>();
for (int i = 0; i<30; i++) {
    multipleSpinnerSearchItemList.add(new FlexItem("Item " +String.valueOf(i), i, false));
}

spinnerMultipleSearch.setData(multipleSpinnerSearchItemList, new FlexListener() {
    @Override
    public void onItemSelected(List<FlexItem> items, int position) {
        // do your thing
    }
});
```

Retrieving selected data from spinner:
```
if (!spinnerMultipleSearch.getSelectedItems().isEmpty()) {
  for (FlexItem item: spinnerMultipleSearch.getSelectedItems()) {
    // do your thing
  }
}
```

### Usage Notes

FlexSpinner uses a FlexItem Object to keep data. It includes the text that shows up in your spinner and two versions of identification: one an Integer and one a String. A FlexItem can be instantiated with either an Integer id or a String id. Use whichever best suits your convenience.

FlexSpinner uses 2 color variables: 
- one highlightColor, which defines the color of the title divider, the selected item and the OK button 
- one default textColor, which defines the color of unselected text in the spinner

These variables must be set.
